package harborlogix.ops;

import harborlogix.cargo.CargoUnit;
import harborlogix.clients.Client;
import java.util.ArrayList;

/**
 * SKELETON - and the most important file in the assignment.
 *
 * THE RULE
 * --------
 * This file must NOT contain:
 *   - the name of any CargoUnit subclass
 *   - the name of any Client subclass
 *   - the word `instanceof`
 *   - any cast to a hierarchy type
 *
 * Verify with:
 *   java harborlogix.tools.OpenClosedCheck src/harborlogix/ops/Yard.java
 *
 * Yard knows there is *a* cargo unit and *a* client. It knows which questions
 * to ask them. It must not know what kind they are.
 */
public class Yard {

    // TODO: private final String yardName;
    // TODO: private final int capacity;
    // TODO: private final ArrayList<CargoUnit> units = new ArrayList<>();

    public Yard(String yardName, int capacity) {
        // TODO: validate and assign
        throw new UnsupportedOperationException("TODO Yard constructor");
    }

    public String getYardName() { throw new UnsupportedOperationException("TODO"); }
    public int getCapacity()    { throw new UnsupportedOperationException("TODO"); }
    public int getUnitCount()   { throw new UnsupportedOperationException("TODO"); }

    /**
     * Returns the stored units.
     * THINK: should this return the internal list, or a copy? Your choice
     * affects encapsulation, and you will be asked about it.
     */
    public ArrayList<CargoUnit> getUnits() {
        throw new UnsupportedOperationException("TODO getUnits");
    }

    /**
     * Adds a unit.
     * Reject null with IllegalArgumentException.
     * Reject a duplicate unit ID with IllegalArgumentException.
     * Reject exceeding capacity with IllegalStateException.
     * Think about why those two situations deserve different exception types.
     */
    public void receive(CargoUnit unit) {
        throw new UnsupportedOperationException("TODO receive");
    }

    /** Sum of every unit's daily fee. */
    public double totalDailyRevenue() {
        throw new UnsupportedOperationException("TODO totalDailyRevenue");
    }

    /**
     * Total owed by one client: sum of totalStorageCharge() over that client's
     * units, reduced by that client's own discount percentage.
     * Match clients by clientId, not by object identity.
     */
    public double invoiceFor(Client client) {
        throw new UnsupportedOperationException("TODO invoiceFor");
    }

    /** The heaviest unit in the yard, or null if the yard is empty. */
    public CargoUnit heaviestUnit() {
        throw new UnsupportedOperationException("TODO heaviestUnit");
    }

    /** Prints one line per unit plus its safety briefing, then the daily revenue. */
    public void printManifest() {
        throw new UnsupportedOperationException("TODO printManifest");
    }
}
