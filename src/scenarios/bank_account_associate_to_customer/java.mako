% if mode == 'definition':
BankAccount().associateToCustomer(Customer customer)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Customer customer = new Customer("/customers/CU2718cI8PkMdFyPjboZLZfn");
BankAccount bankAccount = new BankAccount("/bank_accounts/BA2gul8YMjFWnFk0fFHXwX6g");

bankAccount.associateToCustomer(customer);

% endif

