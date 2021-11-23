import java.util.*;

public class Bank {

    private static HashMap<String, Client> accounts = new HashMap<>();
    private static HashMap<String, Set<Account>> clients = new HashMap<>();

    public Client findClient (String account) {
        return accounts.get(account);
    }

    public Set<Account> findAccount (String client) {
        return clients.get(client);
    }

    public static void main(String[] args) {

        Client ivanov = new Client("Иванов", 30);
        Client petrov = new Client("Петров", 45);
        Client sidorov = new Client("Сидоров", 21);

        Account ivanovAccount = new Account(ivanov, "12345");
        Account ivanovAccount2 = new Account(ivanov, "56789");
        Account petrovAccount = new Account(petrov, "574837");
        Account sidorovAccount = new Account(sidorov, "957647");

        ivanov.addAccount(ivanovAccount);
        ivanov.addAccount(ivanovAccount2);
        petrov.addAccount(petrovAccount);
        sidorov.addAccount(sidorovAccount);

        clients.put(ivanov.getName(), ivanov.getActiveAccounts());
        clients.put(petrov.getName(), petrov.getActiveAccounts());
        clients.put(sidorov.getName(), sidorov.getActiveAccounts());

        accounts.put(ivanovAccount.getAccountNumber(),ivanov);
        accounts.put(ivanovAccount2.getAccountNumber(),ivanov);
        accounts.put(petrovAccount.getAccountNumber(),petrov);
        accounts.put(sidorovAccount.getAccountNumber(),sidorov);

        Bank bank = new Bank();
        System.out.println(bank.findAccount("Иванов"));
        System.out.println(bank.findAccount("Петров"));
        System.out.println(bank.findClient("12345"));

    }
}
