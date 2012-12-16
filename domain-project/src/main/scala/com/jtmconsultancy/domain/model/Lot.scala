package com.jtmconsultancy.domain.model

import com.jtmconsultancy.domain.schema.ScalatraEntity


case class Lot(
                var name: String,
                var description: String,
                var bid: Double
                ) extends ScalatraEntity


object Lot {

  def apply(): Lot = Lot("", "", 0d)

}
