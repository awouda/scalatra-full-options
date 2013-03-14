package com.jtmconsultancy.domain.model

import com.jtmconsultancy.domain.schema.{ScalatraAppSchema, ScalatraEntity}
import java.util.Date
import org.squeryl.dsl.OneToMany


case class Auction(
                    var name: String,
                    var description: String,
                    var startDate: Date
                    ) extends ScalatraEntity {


  lazy val lots: OneToMany[Lot] = ScalatraAppSchema.auctionToLots.left(this)

}


object Auction {

  def apply(): Auction = Auction("", "", new Date())

}
