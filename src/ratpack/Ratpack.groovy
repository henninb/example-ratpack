import postgres.PostgresModule
import ratpack.config.ConfigData
import ratpack.config.ConfigDataBuilder
import ratpack.groovy.sql.SqlModule
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.hikari.HikariModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack


ratpack {
    serverConfig {
        port(5050)
    }
    bindings {

        module MarkupTemplateModule
        module(HikariModule) { config ->
            //org.postgresql.ds.PGPoolingDataSource
            config.dataSourceClassName = 'org.postgresql.ds.PGSimpleDataSource'

            config.addDataSourceProperty("serverName", "localhost")
            config.addDataSourceProperty("databaseName", "finance_db")
            config.addDataSourceProperty("portNumber", "5432")
            config.addDataSourceProperty("user", "henninb")
            config.addDataSourceProperty("password", "monday1")

            config.setMaximumPoolSize(10)
            config.setMinimumIdle(30000) // mill
            config.setIdleTimeout(1) // minutes
            config.setConnectionTimeout(1500) // mill
        }
        //module(DbModule)


    }

    handlers {
        get {
            render groovyMarkupTemplate("index.gtpl", title: "My Finance App")
        }

        files { dir "public" }
    }
}
