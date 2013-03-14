package com.jtm.routes

import com.jtm.routes.dbsupport.DBSessionSuport
import org.scalatra._
import scalate.ScalateSupport
import com.jtmconsultancy.domain.schema.ScalatraAppSchema._
import com.jtmconsultancy.domain.model._

class LotServlet extends ScalatraServlet with ScalateSupport with DBSessionSuport {


  before() {
    contentType = "text/html"
  }

  get("/initdb") {
    lots_table.insert(TestData.hunderdLots)
    Ok
  }

  get("/create") {
    val getAllAuctions = auctions.toList
    scaml("/lot/create",("auctions",getAllAuctions))
  }

  get("/list") {

    val getAllLots = lots.toList
    scaml("/lot/list", ("lots", getAllLots))

  }

  post("/post") {
    val action = params("btn")

    action match {
      case "cancel" => redirect("list")
      case _ => {
        val newLot = Lot(params("name"), params("description"),params("bid").toDouble, params("auctionId").toLong)
        lots_table.insert(newLot)
        redirect("list")
      }
    }

  }


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

