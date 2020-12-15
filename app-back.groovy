#! /usr/bin/env groovy

@Grab('io.ratpack:ratpack-groovy:1.8.0')
@Grab('org.slf4j:slf4j-simple:1.7.0')

import static ratpack.groovy.Groovy.ratpack

println('test')

def x = [1,2,3,4,5]
println x.first()
String test = 'test1|test2|test3|test4'
String[] list = test.split('\\|')
list.each {it -> println it}
List<String> myList = Arrays.asList(list)
def map = [:]

def y = 'test1|test2|test3|test4'.split('\\|').findAll { !it.trim().empty }

//leftShift operator 'x.add(6)' is the same as 'x << 6'
x << 6

// ternary operator
def result = list.first() ? 'Found' : 'Not found'

// Elvis operator is shorthand for ternary operator
def displayName = 'user.name' ? 'user.name': 'Anonymous'
def displayName1 = 'user.name' ?: 'Anonymous'

ratpack {
  handlers {
    get {
       render "hello world"
    }
  }
}
