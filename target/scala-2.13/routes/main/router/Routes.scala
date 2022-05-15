// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  AppController_0: controllers.AppController,
  // @LINE:6
  EmployeeController_1: controllers.EmployeeController,
  // @LINE:18
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    AppController_0: controllers.AppController,
    // @LINE:6
    EmployeeController_1: controllers.EmployeeController,
    // @LINE:18
    Assets_2: controllers.Assets
  ) = this(errorHandler, AppController_0, EmployeeController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AppController_0, EmployeeController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.AppController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees""", """controllers.EmployeeController.listEmployees"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees""", """controllers.EmployeeController.createEmployee"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""" + "$" + """id<[^/]+>""", """controllers.EmployeeController.readEmployee(id:reactivemongo.bson.BSONObjectID)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""" + "$" + """id<[^/]+>""", """controllers.EmployeeController.updateEmployee(id:reactivemongo.bson.BSONObjectID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""" + "$" + """id<[^/]+>""", """controllers.EmployeeController.deleteEmployee(id:reactivemongo.bson.BSONObjectID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_AppController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_AppController_index0_invoker = createInvoker(
    AppController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AppController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_EmployeeController_listEmployees1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees")))
  )
  private[this] lazy val controllers_EmployeeController_listEmployees1_invoker = createInvoker(
    EmployeeController_1.listEmployees,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "listEmployees",
      Nil,
      "GET",
      this.prefix + """employees""",
      """ employee routing""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_EmployeeController_createEmployee2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees")))
  )
  private[this] lazy val controllers_EmployeeController_createEmployee2_invoker = createInvoker(
    EmployeeController_1.createEmployee,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "createEmployee",
      Nil,
      "POST",
      this.prefix + """employees""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:12
  private[this] lazy val controllers_EmployeeController_readEmployee3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmployeeController_readEmployee3_invoker = createInvoker(
    EmployeeController_1.readEmployee(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "readEmployee",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "GET",
      this.prefix + """employees/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_EmployeeController_updateEmployee4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmployeeController_updateEmployee4_invoker = createInvoker(
    EmployeeController_1.updateEmployee(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "updateEmployee",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "PUT",
      this.prefix + """employees/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_EmployeeController_deleteEmployee5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmployeeController_deleteEmployee5_invoker = createInvoker(
    EmployeeController_1.deleteEmployee(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "deleteEmployee",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "DELETE",
      this.prefix + """employees/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_AppController_index0_route(params@_) =>
      call { 
        controllers_AppController_index0_invoker.call(AppController_0.index())
      }
  
    // @LINE:6
    case controllers_EmployeeController_listEmployees1_route(params@_) =>
      call { 
        controllers_EmployeeController_listEmployees1_invoker.call(EmployeeController_1.listEmployees)
      }
  
    // @LINE:11
    case controllers_EmployeeController_createEmployee2_route(params@_) =>
      call { 
        controllers_EmployeeController_createEmployee2_invoker.call(EmployeeController_1.createEmployee)
      }
  
    // @LINE:12
    case controllers_EmployeeController_readEmployee3_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_EmployeeController_readEmployee3_invoker.call(EmployeeController_1.readEmployee(id))
      }
  
    // @LINE:13
    case controllers_EmployeeController_updateEmployee4_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_EmployeeController_updateEmployee4_invoker.call(EmployeeController_1.updateEmployee(id))
      }
  
    // @LINE:14
    case controllers_EmployeeController_deleteEmployee5_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_EmployeeController_deleteEmployee5_invoker.call(EmployeeController_1.deleteEmployee(id))
      }
  
    // @LINE:18
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
