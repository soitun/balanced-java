% if mode == 'definition':
CardHold().capture(Map<String, Object> payload)

% else:
Balanced.configure("ak-test-1ByQgRpcQLTwmOhCBUofyIHm0r96qPm8s");

CardHold cardHold = new CardHold("/card_holds/HLqY5FcrUWcnBzMkHpKK1WB");

Map<String, Object> payload = new HashMap<String, Object>();
payload.put("amount", 1000);
payload.put("description", "Some descriptive text for the debit in the dashboard");
payload.put("appears_on_statement_as", "ShowsUpOnStmt");

try {
    cardHold.capture(payload);
}
catch (HTTPError e) {}

% endif

