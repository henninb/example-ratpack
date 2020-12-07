package finance.domain

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

//import javax.persistence.Entity
//import javax.persistence.Id

@ToString
//@Immutable
//@CompileStatic
@Entity
class Category implements GormEntity<Category> {
    Long categoryId
    String category
    Boolean activeStatus
}
