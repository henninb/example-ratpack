package finance.repositories

import finance.domain.Category
import groovy.transform.CompileStatic
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.SelectJoinStep
import org.jooq.impl.DSL
import ratpack.exec.Blocking
import ratpack.exec.Promise
import javax.sql.DataSource

@CompileStatic
class CategoryRepository {
    private final DSLContext create

    CategoryRepository(DataSource ds) {
        this.create = DSL.using(ds, SQLDialect.H2)
    }

//    Promise<List<Category>> getAll() {
//        SelectJoinStep all = create.select().from("SELECT * FROM t_category")
//        return Blocking.get { all.fetchInto(Category.class) }
//    }
}






