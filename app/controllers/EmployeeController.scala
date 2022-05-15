package controllers

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.mvc.ControllerComponents
import reactivemongo.bson.BSONObjectID
import play.api._
import play.api.mvc._
import play.api.libs.json._
import repositories.EmployeeRepository
import scala.concurrent.{ExecutionContext, Future}

import models.Employee

class EmployeeController @Inject() (implicit
    ec: ExecutionContext,
    components: ControllerComponents,
    employeeRepo: EmployeeRepository
) extends AbstractController(components) {

  def listEmployees = Action.async {
    employeeRepo.list().map { employees =>
      Ok(Json.toJson(employees))
    }
  }

  def createEmployee = Action.async(parse.json) {
    _.body
      .validate[Employee]
      .map { employee =>
        employeeRepo.create(employee).map { _ => Created }
      }
      .getOrElse(Future.successful(BadRequest("Invalid Format")))
  }

  def readEmployee(id: BSONObjectID) = Action.async {
    employeeRepo.read(id).map { maybeEmployee =>
      maybeEmployee
        .map { employee =>
          Ok(Json.toJson(employee))
        }
        .getOrElse(NotFound)
    }
  }

  def updateEmployee(id: BSONObjectID) = Action.async(parse.json) {
    _.body
      .validate[Employee]
      .map { employee =>
        employeeRepo.update(id, employee).map {
          case Some(employee) => Ok(Json.toJson(employee))
          case _              => NotFound
        }
      }
      .getOrElse(Future.successful(BadRequest("Invalid format")))
  }

  def deleteEmployee(id: BSONObjectID) = Action.async {
    employeeRepo.delete(id).map {
      case Some(employee) => Ok(Json.toJson(employee))
      case _              => NotFound
    }
  }
}
