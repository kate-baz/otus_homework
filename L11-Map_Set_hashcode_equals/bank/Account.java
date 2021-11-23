public class Account {

    private String accountNumber;
    private Client client;

    Account (Client client, String number) {
        this.accountNumber = number;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int hashCode() {
        return this.accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;

        Account otherClient = (Account) object;
        return accountNumber.equals(otherClient.accountNumber);
    }

    @Override
    public String toString() {
        return this.accountNumber;
    }
}
