package finance.modules

import com.google.inject.AbstractModule
import com.google.inject.Provides
import finance.domain.Category
import finance.services.CategoryService
import groovy.transform.CompileStatic
import org.grails.orm.hibernate.HibernateDatastore

@CompileStatic
class GormModule extends AbstractModule {

    @Override
    protected void configure() {}

    @Provides
    static HibernateDatastore hibernateDatastore() {
        Map<String, Object> configuration = [
                'hibernate.hbm2ddl.auto':'update',
                'dataSource.driverClassName':'org.postgresql.Driver',
                'dataSource.url':'jdbc:postgresql://localhost:5432/finance_test_db',
                'dataSource.username':'henninb',
                'dataSource.password':'monday1',
                'dataSource.dialect':'org.hibernate.dialect.PostgreSQLDialect',

        ] as Map<String, Object>

        //new HibernateDatastore(configuration, getClass().getPackage())
        new HibernateDatastore(configuration, Category)
    }
}
