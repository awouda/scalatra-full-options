import com.jtm.routes.{AuctionServlet, MainServlet, LotServlet}
import com.jtmconsultancy.domain.db.ScalatraEntitiesDB
import org.scalatra._
import javax.servlet.ServletContext

/**
 * This is the Scalatra bootstrap file. You can use it to mount servlets or
 * filters. It's also a good place to put initialization code which needs to
 * run at application start (e.g. database configurations), and init params.
 */
class Scalatra extends LifeCycle {
  override def init(context: ServletContext) {


    ScalatraEntitiesDB.initSquerylDB()

    // Mount one or more servlets
    context.mount(new MainServlet, "/*")
    context.mount(new LotServlet, "/lot/*")
    context.mount(new AuctionServlet, "/auction/*")
  }
}
