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
        sql.execute("drop table if exists public.t_example")
        sql.execute("create table public.t_example (id varchar(36) primary key, name text)")
        println 'onStart for ExampleService was called.'
    }

    void createTables() {
        sql.execute("drop table if exists public.t_example")
        sql.execute("create table public.t_example (id varchar(36) primary key, name text)")
    }

    private Sql getSql() {
        new Sql(dataSource)
    }
}
