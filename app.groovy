#! /usr/bin/env groovy

@GrabConfig(systemClassLoader = true)
@Grab('io.ratpack:ratpack-groovy:1.8.0')
@Grab('org.slf4j:slf4j-simple:1.7.0')
//@Grab('org.postgresql:postgresql:42.2.18')
@Grab('org.xerial:sqlite-jdbc:3.34.0')
@Grab('com.fasterxml.jackson.core:jackson-databind:2.12.0')
//@Grab('ch.qos.logback:logback-classic:1.2.3')

import static ratpack.groovy.Groovy.ratpack
//import java.sql.*
import groovy.sql.Sql
import com.fasterxml.jackson.databind.*
//import com.fasterxml.jackson.core.type.*

class Channel {
    String description
    String category
    Integer channel
}

void exampleFunction() {
    println('test')
    def x = [1, 2, 3, 4, 5]
    println x.first()
    String test = 'test1|test2|test3|test4'
    String[] list = test.split('\\|')
    list.each { it -> println it }
    List<String> myList = Arrays.asList(list)
    def map = [:]

    def sql = Sql.newInstance("jdbc:sqlite:pluto.db", "org.sqlite.JDBC")
    sql.eachRow("select * from t_channel where channel=50") {
        println("description=${it.description}, category=${it.category}")
    }
}

String findChannel(String number = 50) {
    String result = ""
    ObjectMapper mapper = new ObjectMapper()


    Sql sql = Sql.newInstance("jdbc:sqlite:pluto.db", "org.sqlite.JDBC")
    sql.eachRow("SELECT * from t_channel WHERE channel=:number", [number:number]) {
        Channel channel = new Channel()
        channel.description = it.description
        channel.category = it.category
        channel.channel = it.channel
        result = mapper.writeValueAsString(channel)
    }
    return result
}

String findCategoryChannels(String category = 'explore') {
    List<Channel> channels = []
    ObjectMapper mapper = new ObjectMapper()

    Sql sql = Sql.newInstance("jdbc:sqlite:pluto.db", "org.sqlite.JDBC")
    sql.eachRow("SELECT * from t_channel WHERE category=:category", [category:category]) {
        Channel channel = new Channel()
        channel.description = it.description
        channel.category = it.category
        channel.channel = it.channel
        channels.add(channel)
    }
    return mapper.writeValueAsString(channels)
}

//curl -s 'http://localhost:5050'
//curl -s 'http://localhost:5050/category/seasonal' | jq
ratpack {
    handlers {
        get {
            exampleFunction()
            render "hello world"
        }
        get('channel') {
            render findChannel()
        }
        get('channel/:number') { ctx ->
            String number = ctx.getPathTokens().get("number")
            String payload = findChannel(number)
            ctx.render(payload)
            //render findChannel()
        }
        get('category/:name') { ctx ->
            String name = ctx.getPathTokens().get("name")
            String payload = findCategoryChannels(name)
            ctx.render(payload)
        }
    }
}
