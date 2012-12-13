package example

import org.scalatest.FunSuite
import scala.collection.mutable.Stack
import org.slf4j.LoggerFactory

 
class TestLogSuite extends FunSuite {

   val logger = LoggerFactory.getLogger(classOf[TestLogSuite])
 
 
  test("testing slf4j") {

    logger.warn("warning") 
    logger.info("information") 
    logger.trace("tracing") 
    logger.debug("debugging") 
  }
 



}

