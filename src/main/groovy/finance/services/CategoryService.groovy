package finance.services

import finance.domain.Category
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.grails.orm.hibernate.HibernateDatastore
import ratpack.exec.Blocking
import ratpack.service.Service
import ratpack.service.StartEvent

@CompileStatic
class CategoryService implements Service {


    void onStart(StartEvent e) throws Exception {
        println 'Category Service onStart'
        e.getRegistry().get(HibernateDatastore)
        Blocking.exec {
                Category.withNewSession {
                Category category = new Category()
                //category.categoryId = 1180
                category.category = 'save-it'
                category.activeStatus = true
                Category category1 = category.save()
                println category1.category
            }
            //populateWithSampleData()
//            Category category = new Category()
//            //category.categoryId = 1176
//            category.category = 'stuff'
//            category.activeStatus = true
//            Category category1 = category.save()

            println 'completed added foo - with save()'
        }
        println 'completed added foo'
    }

//    @Transactional
//    static void populateWithSampleData() {
//        Category category = new Category()
//        category.category = 'foo'
//        category.activeStatus = true
//        category.save()
//    }
}
