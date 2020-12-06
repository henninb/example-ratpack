@Grab('io.ratpack:ratpack-groovy:1.6.1')
import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'Hello World from Ratpack with Groovy!!'
        }    
    }
}
