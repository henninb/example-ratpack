package finance.services

import finance.domain.Category
import groovy.transform.CompileStatic
import groovy.util.logging.Log
import org.grails.orm.hibernate.HibernateDatastore
import ratpack.exec.Blocking
import ratpack.service.Service
import ratpack.service.StartEvent

@Log
@CompileStatic
class CategoryService implements Service {


    void onStart(StartEvent e) throws Exception {
        log.info 'Category Service onStart'
        e.getRegistry().get(HibernateDatastore)
        Blocking.exec {
                Category.withNewSession {
                Category category = new Category()
                //category.categoryId = 1180
                category.category = 'save-it'
                category.activeStatus = true
                Category category1 = category.save()
                log.info category1.category
            }
            //populateWithSampleData()
//            Category category = new Category()
//            //category.categoryId = 1176
//            category.category = 'stuff'
//            category.activeStatus = true
//            Category category1 = category.save()

            log.info( 'completed added foo - with save()')
        }
        log.info 'completed added foo'
    }

    static int addNumbers(int x, int y) {
        return x+y
    }

//    @Transactional
//    static void populateWithSampleData() {
//        Category category = new Category()
//        category.category = 'foo'
//        category.activeStatus = true
//        category.save()
//    }
}
