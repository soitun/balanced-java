package hold_list;

import com.balancedpayments.*;
import com.balancedpayments.errors.*;
import java.util.HashMap;
import java.util.Map;

public class hold_list {

public static void main(String[] args) throws HTTPError, NoResultsFound, MultipleResultsFound {
Balanced.configure("ak-test-1p1Tsac7gHeMQowL2seB7ieliuAJAufyq");

Hold.Collection holds = new Hold.Collection("/v1/marketplaces/TEST-MP5FKPQwyjvVgTDt7EiRw3Kq/holds");

}
}

