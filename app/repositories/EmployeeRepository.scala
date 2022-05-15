package repositories;

import javax.inject._
import reactivemongo.api.bson.collection.BSONCollection
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.play.json._
import scala.concurrent.{ExecutionContext, Future}

import reactivemongo.api.commands.bson.BSONCountCommandImplicits._

import models.Employee
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.{BSONDocument, BSONObjectID}

import org.joda.time.DateTime
import reactivemongo.api.commands.WriteResult

import reactivemongo.play.json.collection.JSONCollection

import models.Employee

@Singleton
class EmployeeRepository @Inject() (implicit
    ec: ExecutionContext,
    reactiveMongoApi: ReactiveMongoApi
) {

  def collection: Future[JSONCollection] =
    reactiveMongoApi.database.map(_.collection("employees"))

  def list(limit: Int = 100): Future[Seq[Employee]] =
    collection.flatMap(
      _.find(BSONDocument())
        .cursor[Employee](ReadPreference.Primary)
        .collect[Seq](limit, Cursor.FailOnError[Seq[Employee]]())
    )

  def read(id: BSONObjectID): Future[Option[Employee]] = {
    collection.flatMap(
      _.find(BSONDocument("_id" -> id), Option.empty[Employee]).one[Employee]
    )
  }

  def create(employee: Employee): Future[WriteResult] = {
    collection.flatMap(
      _.insert(employee)
    )
  }

  def update(id: BSONObjectID, employee: Employee): Future[Option[Employee]] =
    collection.flatMap(
      _.findAndUpdate(
        BSONDocument("_id" -> id),
        BSONDocument(
          f"$$set" -> BSONDocument(
            "_id" -> employee._id,
            "name" -> employee.name,
            "email" -> employee.email
          )
        ),
        true
      ).map(_.result[Employee])
    )

  def delete(id: BSONObjectID): Future[Option[Employee]] =
    collection.flatMap(
      _.findAndRemove(BSONDocument("_id" -> id)).map(_.result[Employee])
    )

}
