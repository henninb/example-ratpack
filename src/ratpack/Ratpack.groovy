import postgres.PostgresModule
import ratpack.config.ConfigData
import ratpack.config.ConfigDataBuilder
import ratpack.groovy.sql.SqlModule
import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {

      def map = ['postgres.user'        : 'postgres',
                                 'postgres.password'    : 'secret',
                                 'postgres.portNumber'  : 5432,
                                 'postgres.databaseName': 'postgres',
                                 'postgres.serverName'  : '192.168.99.100'] as Map<String, String>

      final ConfigData configData = ConfigData.of { ConfigDataBuilder builder ->
          builder.props(map)
          builder.build()
      }

      // Create instance of PostgresConfig
      // that is used for the
      // configurable module PostgresModule.
      //bindInstance (PostgresConfig, configData.get('/postgres', PostgresConfig) as Object)
      // Initialise module to create DataSource.
      //module PostgresModule


      //module SqlModule
    module MarkupTemplateModule


  }

  handlers {
    get {
      render groovyMarkupTemplate("index.gtpl", title: "My Finance App")
    }

    files { dir "public" }
  }
}
