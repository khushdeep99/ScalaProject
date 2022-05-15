package controllers

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.mvc.ControllerComponents
import play.api._
import play.api.mvc._
import play.api.libs.json._
import repositories.EmployeeRepository

@Singleton
class AppController @Inject() (implicit
    ec: ExecutionContext,
    cc: ControllerComponents,
    employeeRepo: EmployeeRepository
) extends AbstractController(cc) {

  // def validateLoginGet(username: String, password: String) = Action {
  //   Ok(s"$username logged in with $password")
  // }

  // def validateLoginPost = Action { request =>
  //   val postVals = request.body.asFormUrlEncoded

  //   postVals
  //     .map { args =>
  //       val username = args("username").head
  //       val password = args("password").head

  //       if (username == "iamhr" && password == "secret") {

  //         Redirect("categories")
  //       } else {
  //         Ok("Wrong Credentials")
  //         // Redirect("employees")
  //       }

  //     }
  //     .getOrElse(Ok("Wrong Credentials"))
  // }

  def index() = Action {
    Ok("working")
  }

  // def showCategories() = Action {
  //   Ok(views.html.categories())
  // }

  // def createEmp() = Action {
  //   Ok(views.html.create())
  // }

  // def deleteEmp() = Action {
  //   Ok(views.html.delete())
  // }

  // def updateEmp() = Action {
  //   Ok(views.html.update())
  // }

}
