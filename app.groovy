#! /usr/bin/env groovy

//@GrabConfig(autoDownload=true)
//@GrabResolver(name='restlet', root='http://maven.restlet.org/')
//@GrabResolver(name='restlet', root='http://maven.restlet.org/')
// @GrabResolver(name='restlet', root='http://maven.restlet.org/')
@Grab('io.ratpack:ratpack-groovy:1.8.0')
@Grab('org.slf4j:slf4j-simple:1.7.0')


//groovysh { groovyVersion = '2.3.0' }

import static ratpack.groovy.Groovy.ratpack

println('test')

def x = [1,2,3,4,5]
println x.first()
String test = 'test1|test2|test3|test4'
String[] list = test.split('\\|')
list.each {it -> println it}
List<String> myList = Arrays.asList(list)

ratpack {
  handlers {
    get {
       render "hello world"
    }
  }
}
