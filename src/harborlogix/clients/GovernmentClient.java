package harborlogix.clients;

/**
 * SKELETON. A state client. The discount is fixed by statute at 25 percent,
 * so it must NOT be a constructor parameter - model it as a constant.
 * Government cargo always gets priority handling.
 */
public class GovernmentClient extends Client {

    // TODO: public static final double STATUTORY_DISCOUNT = 25.0;
    // TODO: private final String agencyCode;

    public GovernmentClient(String clientId, String name, String agencyCode) {
        super(clientId, name);
        // TODO: validate agencyCode and assign
        throw new UnsupportedOperationException("TODO GovernmentClient constructor");
    }

    public String getAgencyCode() {
        throw new UnsupportedOperationException("TODO getAgencyCode");
    }

    // TODO: override discountPercent(), clientTier(), priorityHandling(), toString()
}
