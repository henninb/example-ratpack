package finance.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Immutable
import groovy.transform.ToString

@ToString
@Immutable
@CompileStatic
//@Entity
class Category {
    Long categoryId
    String categoryName
    Boolean activeStatus

//    @JsonCreator
//    Category(@JsonProperty("categoryId") Long categoryId,
//             @JsonProperty("categoryName") String categoryName,
//             @JsonProperty("activeStatus") Boolean activeStatus) {
//        this(categoryId, categoryName, activeStatus)
//    }

//    Category(Long categoryId, String categoryName, Boolean activeStatus) {
//        this.categoryId = categoryId
//        this.categoryName = categoryName
//        this.activeStatus = activeStatus
//    }

}
