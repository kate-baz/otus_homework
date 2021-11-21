import java.util.*;

public class Bank {

    private static HashMap<Account, Client> accounts = new HashMap<>();
    private static HashMap<Client, Set<Account>> clients = new HashMap<>();

    public Client findClient (Account account) {
        return accounts.get(account);
    }

    public Set<Account> findAccount (Client client) {
        return clients.get(client);
    }

    public static void main(String[] args) {

        Client ivanov = new Client("Иванов", 30);
        Client petrov = new Client("Петров", 45);
        Client sidorov = new Client("Сидоров", 21);

        ivanov.addAccount(new Account(ivanov, "12345"));
        ivanov.addAccount(new Account(ivanov, "56789"));
        petrov.addAccount(new Account(petrov, "574837"));
        sidorov.addAccount(new Account(sidorov, "957647"));

        clients.put(ivanov, ivanov.getActiveAccounts());
        clients.put(petrov, petrov.getActiveAccounts());
        clients.put(sidorov, sidorov.getActiveAccounts());

        Bank bank = new Bank();
        System.out.println(bank.findAccount(ivanov));
        // System.out.println(bank.findClient());

    }
}
