package com.jtmconsultancy.domain.model

import java.util.Date
import com.jtmconsultancy.domain.schema.ScalatraAppSchema

object TestData {

  def hunderdLots = {
    val allAuctions = ScalatraAppSchema.auctions.toList

    1 to 100 map {
      anumber =>
        val auctionId:Long = allAuctions((new util.Random).nextInt(allAuctions.size)).id
        Lot("somename %d," format(anumber), "Some large description", 12.50d,auctionId)
    } toList
  }

  def tenAuctions = {
     1 to 10 map {
       anumber => Auction("somename %d," format(anumber), "Some large description", new Date())
     } toList

  }



}
