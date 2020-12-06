package postgres

import com.google.inject.Provides
import groovy.transform.CompileStatic
import org.postgresql.ds.PGSimpleDataSource
import ratpack.guice.ConfigurableModule

import javax.sql.DataSource

@CompileStatic
class PostgresModule extends ConfigurableModule {

    @Override
    protected void configure() {
    }

    @Provides
    static DataSource dataSource(final PostgresConfig config) {
        createDataSource(config)
    }

    protected static DataSource createDataSource(final PostgresConfig config) {
        new PGSimpleDataSource(
                user: config.user,
                password: config.password,
                serverName: config.serverName,
                databaseName: config.databaseName,
                portNumber: config.portNumber)
    }
}
