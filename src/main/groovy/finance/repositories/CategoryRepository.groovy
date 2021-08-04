package finance.repositories

import finance.domain.Category
import groovy.transform.CompileStatic
import org.jooq.DSLContext
import org.jooq.Result
import org.jooq.SQLDialect
import org.jooq.SelectJoinStep
import org.jooq.impl.DSL
import ratpack.exec.Blocking
import ratpack.exec.Operation
import ratpack.exec.Promise

import com.google.inject.Inject
import javax.sql.DataSource

import static org.jooq.generated.Tables.T_CATEGORY

@CompileStatic
class CategoryRepository {
    private final DSLContext create

    @Inject
    CategoryRepository(DataSource ds) {
        this.create = DSL.using(ds, SQLDialect.POSTGRES)
    }

    Operation insertCategory(Category category) {
        // TODO - Implement addBook function
        return Blocking.op({ -> create.newRecord(T_CATEGORY, category).store() });
    }
//
//    Category selectAllCategories() {
//        Result<Category> categories =
//                DSL.using(configuration)
//                        .selectFrom(TCATEGORY)
//                        .where(condition(book))
//                        .fetch();
//    }

//    Promise<List<Category>> getAll() {
//        SelectJoinStep all = create.select().from("SELECT * FROM t_category")
//        return Blocking.get { all.fetchInto(Category.class) }
//    }
}






