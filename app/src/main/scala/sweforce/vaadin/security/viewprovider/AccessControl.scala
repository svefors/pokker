package sweforce.vaadin.security.viewprovider

import org.apache.shiro.subject.Subject


sealed trait AccessControl {
  //def isDenied(subject: Subject): Boolean
}

case object Anon extends AccessControl{
//  def isDenied(subject: Subject) = false
}

case object Authc extends AccessControl

case class Roles(values: Seq[String]) extends AccessControl

case class Perms(values: Seq[String]) extends AccessControl



//case object ssl extends AccessControl


//object anon extends AccessControl {
//  def isAccessApproved(subject: Subject) = true
//}
//
//object authc extends AccessControl {
//  def isAccessApproved(subject: Subject) = subject.isAuthenticated
//
//  //strategy for how to handle failure, should ask to authenticate
//}
//
//object roles {
//  def apply(anyRoleWillDoJustFine: Seq[String]): AccessControl =
//    new AccessControl {
//      def isAccessApproved(subject: Subject) = anyRoleWillDoJustFine.exists(subject.hasRole(_))
//
//      //should log and display message to contact administrator
//      //message could be displayed in a new view or just as a popup(Notification) or modal
//      //don't have access to create a modal from here
//      //modal or notification should be handled as a ViewChangeListener.
//    }
//}
//
//object perms {
//  def apply(anyPermissionWillDoJustFine: Seq[String]): AccessControl =
//    new AccessControl {
//      def isAccessApproved(subject: Subject) = anyPermissionWillDoJustFine.exists(subject.isPermitted(_))
//
//      //should log and display message to contact administrator
//    }
//}