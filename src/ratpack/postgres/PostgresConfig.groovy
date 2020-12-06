package postgres

import groovy.transform.CompileStatic

@CompileStatic
class PostgresConfig {
    String user
    String password
    String serverName = 'localhost'
    String databaseName
    Integer portNumber = 5432
}
