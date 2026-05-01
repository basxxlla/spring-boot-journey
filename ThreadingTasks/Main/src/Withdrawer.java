public class Withdrawer extends Thread {
    private final BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    public void run() {
        try {
            while (true) {
                account.withdraw(150);
                Thread.sleep(2000); // simulate delay
            }
        } catch (InterruptedException _) {}
    }
}
