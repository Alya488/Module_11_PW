import java.util.*;

interface AuthProvider {
    boolean verify(String name, String key);
}

interface VaultAccess {
    void transfer(int from, int to, double amount);
}

class GringottsAuth implements AuthProvider {
    public boolean verify(String name, String key) {
        System.out.println("Gringotts Auth: Key verified for " + name);
        return true;
    }
}

class GoblinVaults implements VaultAccess {
    public void transfer(int from, int to, double amount) {
        System.out.println("Vaults: Transferred " + amount + " Galleons.");
    }
}

class NotificationService {
    public void sendOwl(String msg) {
        System.out.println("Owl Service: " + msg);
    }
}

class BankingBackend {
    private AuthProvider auth;
    private VaultAccess vaults;
    private NotificationService owls;

    public BankingBackend(AuthProvider a, VaultAccess v, NotificationService n) {
        this.auth = a;
        this.vaults = v;
        this.owls = n;
    }

    public void process(int id, String user, String key, double amount) {
        System.out.println("Manager Draco Malfoy: Processing vault access.");
        if (auth.verify(user, key)) {
            vaults.transfer(id, 999, amount);
            owls.sendOwl("Gold moved.");
            System.out.println("Status: Success.");
        }
    }
}

public class Component_diagram {
    public static void main(String[] args) {
        AuthProvider auth = new GringottsAuth();
        VaultAccess vaults = new GoblinVaults();
        NotificationService owls = new NotificationService();

        BankingBackend gringotts = new BankingBackend(auth, vaults, owls);
        gringotts.process(687, "Hermione Granger", "SecretKey", 500.0);
    }
}

