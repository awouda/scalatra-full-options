package com.jtm.routes

import dbsupport.DBSessionSuport
import org.scalatra.{Ok, ScalatraServlet}
import org.scalatra.scalate.ScalateSupport
import com.jtmconsultancy.domain.schema.ScalatraAppSchema._
import com.jtmconsultancy.domain.model.{Auction, Lot, TestData}
import java.util.Date


class AuctionServlet extends ScalatraServlet with ScalateSupport with DBSessionSuport {


  before() {
    contentType = "text/html"
  }



  get("/create") {
    scaml("/auction/create")
  }

  get("/list") {

    val getAllAuctions = auctions.toList
    scaml("/auction/list", ("auctions", getAllAuctions))

  }

  post("/post") {
    val action = params("btn")

    action match {
      case "cancel" => redirect("list")
      case _ => {
        val newAuction = Auction(params("name"), params("description"),new Date() )
        auctions_table.insert(newAuction)
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





