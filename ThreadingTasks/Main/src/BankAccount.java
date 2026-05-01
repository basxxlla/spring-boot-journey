public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);

        notify(); // wake up withdrawer
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println("Waiting to withdraw... Balance: " + balance);
            try {
                wait(); // release lock and wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
    }
}
