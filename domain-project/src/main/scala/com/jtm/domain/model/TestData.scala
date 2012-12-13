package com.jtm.domain.model

object TestData {

  def hunderdLots = {
    1 to 100 map {
      anumber =>
        Lot("somename %d" format(anumber), "Some large description", 12.50d)
    } toList
  }


}
