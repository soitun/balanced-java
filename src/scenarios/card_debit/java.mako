% if mode == 'definition':
Card().debit(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-25ZY8HQwZPuQtDecrxb671LilUya5t5G0");

Card card = new Card("/cards/CC33DRVrekWpiHYjxSdVuqWc");

HashMap<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 5000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "Statement text");

try {
    Debit debit = card.debit(payload);
}
catch (HTTPError e) {}

% endif

