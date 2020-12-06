package finance.domain

import java.sql.Date

class Transaction {
    String guid = '4ea3be58-3993-abcd-88a2-4ffc7f1d73bd'
    Long accountId = 0
    AccountType accountType = AccountType.Credit
    String accountNameOwner = 'chase_brian'
    Date transactionDate = new Date(1553645394)
    String description = 'aliexpress.com'
    String category = 'online'
    BigDecimal amount = 3.14G
    TransactionState transactionState = TransactionState.Cleared
    Boolean reoccurring = false
    ReoccurringType reoccurringType = ReoccurringType.Undefined
    String notes = 'my note to you'
}
