#! /usr/bin/env groovy

@GrabConfig(systemClassLoader=true)
@Grab('io.ratpack:ratpack-groovy:1.8.0')
@Grab('org.slf4j:slf4j-simple:1.7.0')
@Grab('org.postgresql:postgresql:42.2.18')
@Grab('org.xerial:sqlite-jdbc:3.34.0')
//@Grab('ch.qos.logback:logback-classic:1.2.3')

import static ratpack.groovy.Groovy.ratpack
import java.sql.*
import groovy.sql.Sql

void exampleFunction() {
  println('test')
  def x = [1,2,3,4,5]
  println x.first()
  String test = 'test1|test2|test3|test4'
  String[] list = test.split('\\|')
  list.each {it -> println it}
  List<String> myList = Arrays.asList(list)
  def map = [:]

  def sql = Sql.newInstance("jdbc:sqlite:pluto.db", "org.sqlite.JDBC")
  sql.eachRow("select * from t_channel where channel=50") {
    println("description=${it.description}, category=${it.category}")
  }
}

//curl 'http://localhost:5050'
ratpack {
  handlers {
    get {
       exampleFunction()
       render "hello world"
    }
  }
}
