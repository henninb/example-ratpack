package example.service

import finance.services.CategoryService
import spock.lang.Specification

class CategoryServiceSpec extends  Specification {
    CategoryService categoryService = new CategoryService()

    void 'test add two numbers' () {
        given:
        int x = 5
        int y = 4
        int expectedResult = 9

        when:
        int actualResult = categoryService.addNumbers(x,y)

        then:
        actualResult == expectedResult
    }
}
