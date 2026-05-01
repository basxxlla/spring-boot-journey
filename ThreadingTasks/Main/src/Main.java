public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start(); // NOT run()

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        //Thread.sleep()
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Join()
        Worker t3 = new Worker("Thread-1");
        Worker t4 = new Worker("Thread-2");

        t3.start();
        t4.start();

        t3.join(); // main waits
        t4.join();

        System.out.println("Main thread finished");

        //Bank Account

        BankAccount account = new BankAccount();

        Depositor d = new Depositor(account);
        Withdrawer w = new Withdrawer(account);

        d.start();
        w.start();
    }
}