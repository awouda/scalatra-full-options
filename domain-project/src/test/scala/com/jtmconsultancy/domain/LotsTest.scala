package com.jtmconsultancy.domain

import db.ScalatraEntitiesDB
import com.jtmconsultancy.domain.model._
import com.jtmconsultancy.domain.schema.ScalatraAppSchema._

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.squeryl.PrimitiveTypeMode._

class LotsTest extends FunSuite with BeforeAndAfter {

  ScalatraEntitiesDB.initSquerylDB()

  test("insert 10 auctions and 100 lots") {
    inTransaction {
      drop
      create
      auctions_table.insert(TestData.tenAuctions)
      lots_table.insert(TestData.hunderdLots)

      assert(lots.size == 100)
    }
  }
}
