package finance.services

import groovy.sql.Sql
import ratpack.service.Service
import ratpack.service.StartEvent
import javax.sql.DataSource

import com.google.inject.Inject
import com.google.inject.Singleton

@Singleton
class ExampleService implements Service {

    private final DataSource dataSource

    @Inject
    ExampleService(DataSource dataSource) {
        this.dataSource = dataSource
    }

    @Override
    void onStart(StartEvent event) throws Exception {
        createTables()
    }

    void createTables() {
        sql.execute("drop table if exists hubs")
        sql.execute("create table public.hubs (id varchar(36) primary key, name VARCHAR (256), hardwareType VARCHAR (256)); commit")
    }

    private Sql getSql() {
        new Sql(dataSource)
    }
}
