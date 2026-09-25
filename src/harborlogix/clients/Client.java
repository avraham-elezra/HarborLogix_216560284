package harborlogix.clients;

public class Client {

    private final String clientId;
    private final String name;

    public Client(String clientId, String name) {
        if (clientId == null || clientId.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.clientId = clientId;
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public double discountPercent() {
        return 0.0;
    }

    public String clientTier() {
        return "Standard";
    }

    public boolean priorityHandling() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s [ID=%s, Tier=%s]", name, clientId, clientTier());
    }
}