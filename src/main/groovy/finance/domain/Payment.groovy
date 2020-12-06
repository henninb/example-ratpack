package finance.domain

import java.sql.Date

class Payment {
    String accountNameOwner = 'foo_brian'
    BigDecimal amount = 0.00G
    Date transactionDate = new Date(1605300155000)
    String guidSource = UUID.randomUUID()
    String guidDestination = UUID.randomUUID()
}
