package com.jtm.domain.db


import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.H2Adapter
import java.sql.DriverManager


object ScalatraEntitiesDB {

  Class.forName("org.h2.Driver");

  private val singleconnection = {
    val c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/scalatradb", "sa", "");
    c
  }

  def initSquerylDB() {
    SessionFactory.concreteFactory = Some(() =>
      Session.create(singleconnection, new H2Adapter))
  }

}

/*

bject DBHelper  {

val dbhost = Props.get("db_host").get
val dbname = Props.get("db_name").get
val dbuser = Props.get("db_user").get
val dbpass = Props.get("db_password").get

Class.forName("org.postgresql.Driver");

val connectionpool = {
val cpds = new ComboPooledDataSource
cpds.setDriverClass("org.postgresql.Driver")
cpds.setJdbcUrl("jdbc:postgresql://%s:5432/%s" format(dbhost, dbname))
cpds.setUser(dbuser)
cpds.setPassword(dbpass)
cpds
}

def initSquerylDB() {
SessionFactory.concreteFactory = Some(() =>
Session.create(connectionpool.getConnection(), new PostgreSqlAdapter))

}

}




}


*/

