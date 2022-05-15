package models

import play.api.libs.json.{Json ,OFormat}
import reactivemongo.bson.BSONObjectID
import reactivemongo.play.json._


case class Employee(
    _id: Option[BSONObjectID],
    name: String ,
    email: String
)
object Employee{
    implicit val format:OFormat[Employee] = Json.format[Employee]
}