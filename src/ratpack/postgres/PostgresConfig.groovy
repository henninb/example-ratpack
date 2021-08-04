package postgres

import groovy.transform.CompileStatic

@CompileStatic
class PostgresConfig {
    String user = 'henninb'
    String password = 'monday1'
    String serverName = 'localhost'
    String databaseName = 'finance_test_db'
    Integer portNumber = 5432
}
