import com.jtm.domain.db.ScalatraEntitiesDB
import com.jtm.domain.model.TestData
import scalatrademo._
import org.scalatra._
import javax.servlet.ServletContext
import org.squeryl.PrimitiveTypeMode._
import com.jtm.domain.schema.ScalatraAppSchema._

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
  }
}
