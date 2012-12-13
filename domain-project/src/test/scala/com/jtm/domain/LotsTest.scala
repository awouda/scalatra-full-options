package com.jtm.domain

import db.ScalatraEntitiesDB
import com.jtm.domain.model._
import com.jtm.domain.schema.ScalatraAppSchema._

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.squeryl.PrimitiveTypeMode._

class LotsTest extends FunSuite with BeforeAndAfter {

  ScalatraEntitiesDB.initSquerylDB()

  test("insert 100 lots") {
    inTransaction {
      drop
      create
      lots_table.insert(TestData.hunderdLots)

      assert(lots.size == 100)
    }
  }
}
