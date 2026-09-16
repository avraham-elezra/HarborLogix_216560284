package harborlogix.clients;

/**
 * SKELETON. A client with a negotiated discount between 0 and 40 percent.
 * Reject anything outside that range with IllegalArgumentException.
 */
public class ContractClient extends Client {

    // TODO: private final field for the negotiated discount

    public ContractClient(String clientId, String name, double contractDiscount) {
        super(clientId, name);
        // TODO: validate 0..40 and assign
        throw new UnsupportedOperationException("TODO ContractClient constructor");
    }

    // TODO: override discountPercent(), clientTier(), toString()
    //       toString() must reuse super.toString()
}
