% if mode == 'definition':
Order().debitFrom(BankAccount bankAccount, Map<String, Object> payload)

% else:
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4plzFRTGgaoZftGcIJH3Py");
Order order = new Order("/orders/OR483MoeOnJEXwkxqoPdnDF3");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);

try {
    Debit debit = order.debitFrom(bankAccount, payload);
}
catch (HTTPError e) {}

% endif

