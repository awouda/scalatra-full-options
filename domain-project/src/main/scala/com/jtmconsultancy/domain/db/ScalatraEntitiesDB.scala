package com.jtmconsultancy.domain.db


import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.H2Adapter
import java.sql.DriverManager
import com.mchange.v2.c3p0.ComboPooledDataSource


object ScalatraEntitiesDB {

  Class.forName("org.h2.Driver");






  private val singleconnection = {
    val c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/scalatradb", "sa", "");
    c
  }

  def initSquerylDB() {
    SessionFactory.concreteFactory = Some(() =>
      Session.create(connectionpool.getConnection, new H2Adapter))
  }

  val connectionpool = {
    val cpds = new ComboPooledDataSource
    cpds.setDriverClass("org.h2.Driver")
    cpds.setJdbcUrl("jdbc:h2:tcp://localhost/~/scalatradb")
    cpds.setUser("sa")
    cpds.setPassword("")
    cpds
  }



}


