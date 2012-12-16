package com.jtmconsultancy.domain

import db.{ScalatraEntitiesDB}
import org.squeryl.PrimitiveTypeMode._

object Runner extends App {

  ScalatraEntitiesDB.initSquerylDB()

}
