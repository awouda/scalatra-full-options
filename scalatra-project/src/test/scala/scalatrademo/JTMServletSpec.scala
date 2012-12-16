package scalatrademo

import org.scalatra.test.specs2._
import com.jtm.routes.MainServlet

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class JTMServletSpec extends ScalatraSpec {



  def is =
  "GET / on MainServlet"                     ^
    "should return status 200"                  ! root200
                                                end

  addServlet(classOf[MainServlet], "/*")

  def root200 = get("/") {
    status must_== 200
  }


}
