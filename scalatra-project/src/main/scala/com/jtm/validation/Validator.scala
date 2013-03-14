package com.jtm.validation

trait Validator {

  var validationErrors: List[(String, String)] = _


  def doubleValue(input: String, key: String) =    try {
      input.toDouble
    }
    catch {
      case nfe: NumberFormatException => {
        println(nfe)
      }
    }



}
