public class Depositor extends Thread {
    private final BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    public void run() {
        try {
            while (true) {
                account.deposit(100);
                Thread.sleep(1500); // simulate delay
            }
        } catch (InterruptedException _) {}
    }
}