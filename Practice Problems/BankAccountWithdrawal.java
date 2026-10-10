import java.util.*;

class BankAccount {
    String id;
    String type;
    int balance;

    BankAccount(String id, String type, int balance) {
        this.id = id;
        this.type = type;
        this.balance = balance;
    }

    String withdraw(int amount) {
        if (type.equals("Savings")) {
            if (balance - amount < 1000) {
                return id + " rejected: minimum balance 1000";
            }
        } else {
            if (balance - amount < -5000) {
                return id + " rejected: overdraft limit 5000";
            }
        }

        balance -= amount;
        return id + " balance " + balance;
    }
}

public class BankAccountWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("Savings") ||
                parts[0].equals("Current")) {

                String type = parts[0];
                String id = parts[1];
                int balance = Integer.parseInt(parts[2]);

                accounts.put(id,
                    new BankAccount(id, type, balance));

            } else if (parts[0].equals("WITHDRAW")) {

                String id = parts[1];
                int amount = Integer.parseInt(parts[2]);

                if (!accounts.containsKey(id)) {
                    System.out.println("Account not found");
                } else {
                    System.out.println(
                        accounts.get(id).withdraw(amount));
                }
            }
        }

        sc.close();
    }
}