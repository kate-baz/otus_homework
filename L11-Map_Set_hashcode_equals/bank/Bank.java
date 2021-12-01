import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;

public class Bank {

    private static HashMap<Account, Client> accounts = new HashMap<>();
    private static HashMap<Client, Set<Account>> clients = new HashMap<>();

    public Client findClient (Account account) {
        return accounts.get(account);
    }

    public Set<Account> findAccount (Client client) {
        return clients.get(client);
    }

    public static String getUniqueID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static Account createAccount(String accountID, Client client) throws DuplicateAccountException {
        Account newAccount = new Account(client, accountID);
        if (accounts.containsKey(newAccount)) {
            throw new DuplicateAccountException("Account already exists");
        }
        accounts.put(newAccount, client);
        client.addAccount(newAccount);
        clients.put(client, client.getActiveAccounts());
        return newAccount;
    }

    public static void main(String[] args) {

        Client ivanov = new Client("Иванов", 30);
        Client petrov = new Client("Петров", 45);
        Client sidorov = new Client("Сидоров", 21);

        String accountNumber = getUniqueID();
        Bank bank = new Bank();
        Account account1 = null;

        try{
            account1 = createAccount(accountNumber, ivanov);
            createAccount(accountNumber, petrov);
            createAccount(getUniqueID(), sidorov);
            createAccount(getUniqueID(), petrov);
            createAccount(getUniqueID(), sidorov);
        }
        catch (DuplicateAccountException ex) {
            System.out.println(ex.message);
        }
        finally {
            System.out.println(bank.findAccount(ivanov));
            System.out.println(bank.findAccount(petrov));
            System.out.println(bank.findClient(account1));
        }
    }
}
