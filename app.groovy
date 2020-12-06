@Grab('io.ratpack:ratpack-groovy:1.8.0')
//@Grab('io.ratpack:ratpack-groovy:1.3.3')
// @Grab('org.slf4j:slf4j-simple:1.7.0')

//groovysh { groovyVersion = '2.3.0' }

import static ratpack.groovy.Groovy.ratpack

println('test')
ratpack {
  handlers {
    get {
       render "hello world"
    }
  }
}
