package sweforce.vaadin.security.viewprovider

import com.vaadin.navigator.{View, ViewProvider}
import org.apache.shiro.subject.Subject
import sweforce.demo.security.SecurityContext
import sweforce.vaadin.security.viewprovider.SecureViewProvider.{Mapping, ViewAccessControl}


/**
 * Created by sveffa on 23/03/14.
 */
class SecureViewProvider(val securityContext: SecurityContext,
                         val viewAccessControlList: List[ViewAccessControl],
                         val fragmentViewMappings: List[Mapping],
                         val loginView:  View,
                         val unauthorizedView: View) extends ViewProvider {

  def getViewAccessControl(fragment: String) = viewAccessControlList.find(vac => fragment.startsWith(vac._1))

  def getViewName(viewAndParameters: String) = getMapping(viewAndParameters) match {
    case Some(mapping) => mapping._1
    case None => null
  }

  def getMapping(someFrag: String): Option[Mapping] = {
    fragmentViewMappings.find(p => someFrag.startsWith(p._1))
  }

  def isAclBroken(fragment: String): Option[AccessControl] = {
    getViewAccessControl(fragment) match {
      case Some(viewAccessControls) =>
        viewAccessControls._2.find(isDenied(securityContext.getSubject(), _))
      case None => None
    }
  }

  def isDenied(subject: Subject, ac: AccessControl) = ac match {
    case Anon => false
    case Authc => !securityContext.getSubject().isAuthenticated
    case Roles(roleNames) => (roleNames.find(roleName => securityContext.getSubject().hasRole(roleName))) match {
      case Some(_) => false
      case None => true
    }
    case Perms(permissionNames) => (permissionNames.find(securityContext.getSubject().isPermitted(_))) match {
      case Some(_) => false
      case None => true
    }
  }

  def getView(viewName: String) = isAclBroken(viewName) match {
    case Some(acl) => acl match {
      case Authc => loginView
      case Roles(_) => unauthorizedView
      case Perms(_) => unauthorizedView
      case Anon => throw new IllegalArgumentException("Programming Error!")
    }
    case None => getMapping(viewName) match {
      case Some(mapping) => mapping._2
      case None => null
    }
  }

}

object SecureViewProvider {
  type ViewAccessControl = (String, Seq[AccessControl])
  type Mapping = (String, View)
}




