package com.jtm.routes

class MainServlet extends JTMBaseServlet {

  before() {
    contentType = "text/html"
  }

  get("/") {

    scaml("index")

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

