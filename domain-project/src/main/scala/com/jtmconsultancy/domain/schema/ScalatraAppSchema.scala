package com.jtmconsultancy.domain.schema

import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.KeyedEntity
import com.jtmconsultancy.domain.model.{Auction, Lot}

//import org.joda.time.Interval

trait ScalatraEntity extends KeyedEntity[Long] {
  val id: Long = 100l

}


object ScalatraAppSchema extends Schema {

  val lots_table = table[Lot]
  val auctions_table = table[Auction]


  val auctionToLots = oneToManyRelation(auctions_table, lots_table).via((a, l) => a.id === l.auctionId)

  def lots = from(lots_table)(l => select(l))

  def auctions = from(auctions_table)(l => select(l))

}
