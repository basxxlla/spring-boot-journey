public class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println(getName() + " finished");
    }
}
