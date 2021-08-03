package finance.domain

import groovy.transform.ToString

import java.sql.Timestamp

@ToString
class Account {
    Long accountId
    String accountNameOwner
    AccountType accountType
    Boolean activeStatus = true
    String moniker = '0000'
    BigDecimal outstanding = 0.00G
    BigDecimal future = 0.00G
    BigDecimal cleared = 0.00G
    Timestamp dateClosed = new Timestamp(0)
}
