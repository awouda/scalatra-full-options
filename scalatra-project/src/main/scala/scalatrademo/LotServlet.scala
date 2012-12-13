package scalatrademo

import org.scalatra._
import scalate.ScalateSupport
import com.jtm.domain.model.{TestData, Lot}
import org.squeryl.SessionFactory
import com.jtm.domain.schema.ScalatraAppSchema._

class LotServlet extends ScalatraServlet with ScalateSupport {


  before() {
    contentType = "text/html"
    SessionFactory.newSession.bindToCurrentThread
  }


  get("/initdb") {

    lots_table.insert(TestData.hunderdLots)

    Ok


  }



  get("/create") {

    scaml("/lot/create")
  }


  get("/list") {

    val getAllLots = lots.toList

    scaml("/lot/list", ("lots",getAllLots))
  }


//  post("/post") {
//
//    val posted = params("submission")
//
//    scaml("/admin/posted", ("posted", posted))
//
//  }






  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map {
      path =>
        contentType = "text/html"
        layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}

