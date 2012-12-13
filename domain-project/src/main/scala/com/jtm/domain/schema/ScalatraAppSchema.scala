package com.jtm.domain.schema

import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.KeyedEntity
import com.jtm.domain.model.Lot

//import org.joda.time.Interval

trait ScalatraEntity extends KeyedEntity[Long] {
  val id: Long = 100l

}


object ScalatraAppSchema extends Schema {

  val lots_table = table[Lot]


  def lots = from(lots_table)(l => select(l))


}
