import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;

public class Client {

    private String name;
    private int age;
    private Set <Account> activeAccounts;

    Client (String name, int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Not eligible for having a bank account. Age less than 18");
        }
        this.name = name;
        this.age = age;
        this.activeAccounts = new HashSet();
    }

    public String getName() {
        return name;
    }

    public void addAccount (Account account) {
        activeAccounts.add(account);
    }

    public Set<Account> getActiveAccounts() {
        return activeAccounts;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;

        Client otherClient = (Client) object;
        return name.equals(otherClient.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
