package bank_account_delete;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class bank_account_delete {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-2wIOi20ITgc1u1Lw6UM3y5ZZjZ66M8HMf");

BankAccount bankAccount = new BankAccount("/bank_accounts/BA4GVxlUHmn8y0CjAUEcW6Kp");
try {
    bankAccount.unstore();
}
catch (APIError e) {}
catch (NotCreated e) {}

}
}

