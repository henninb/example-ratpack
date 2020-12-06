import ratpack.groovy.template.MarkupTemplateModule
import ratpack.hikari.HikariModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack


ratpack {
    serverConfig {
        port(5050)
        //json("dbconfig.json")
        //require("/daatabase", PostgresConfig)
    }
    bindings {

        module MarkupTemplateModule
        module(HikariModule) { config ->
            //org.postgresql.ds.
            //config.dataSourceClassName = 'org.postgresql.ds.PGSimpleDataSource'
            config.dataSourceClassName = 'org.postgresql.ds.PGPoolingDataSource'

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
    }

    handlers {
        get {
            render groovyMarkupTemplate("index.gtpl", title: "My Finance App")
        }

        files { dir "public" }
    }
}
