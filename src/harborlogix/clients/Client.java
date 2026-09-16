package harborlogix.clients;

/**
 * SKELETON - implement the TODOs.
 *
 * DESIGN DECISION YOU MUST MAKE AND JUSTIFY IN DESIGN.md:
 * Should Client be abstract, like CargoUnit? Or concrete?
 * Both answers are defensible. Pick one, implement it, and defend it.
 * (The skeleton is concrete; change it if you decide otherwise.)
 */
public class Client {

    // TODO: private final fields for clientId and name

    public Client(String clientId, String name) {
        // TODO: validate both (non-null, non-blank) and assign
        throw new UnsupportedOperationException("TODO Client constructor");
    }

    public String getClientId() {
        throw new UnsupportedOperationException("TODO getClientId");
    }

    public String getName() {
        throw new UnsupportedOperationException("TODO getName");
    }

    /** Walk-in clients get no discount. Subclasses may override. */
    public double discountPercent() {
        throw new UnsupportedOperationException("TODO discountPercent");
    }

    public String clientTier() {
        throw new UnsupportedOperationException("TODO clientTier");
    }

    /** Priority clients are unloaded first. */
    public boolean priorityHandling() {
        throw new UnsupportedOperationException("TODO priorityHandling");
    }

    // TODO: override toString()
}
