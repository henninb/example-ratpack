package finance.domain

import java.sql.Timestamp

class Account {
    String accountNameOwner = 'foo_brian'
    AccountType accountType = AccountType.Credit
    Boolean activeStatus = true
    String moniker = '1234'
    BigDecimal totals = 0.00G
    BigDecimal totalsBalanced = 0.00G
    Timestamp dateClosed = new Timestamp(0)
}
