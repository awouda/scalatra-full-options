package com.jtmconsultancy.domain.model

import com.jtmconsultancy.domain.schema.{ScalatraAppSchema, ScalatraEntity}
import org.squeryl.dsl.ManyToOne


case class Lot(
                var name: String,
                var description: String,
                var bid: Double,
                var auctionId:Long
                ) extends ScalatraEntity {

  lazy val auction: ManyToOne[Auction] = ScalatraAppSchema.auctionToLots.right(this)

}


object Lot {

  def apply(): Lot = Lot("", "", 0d,0l)

}
