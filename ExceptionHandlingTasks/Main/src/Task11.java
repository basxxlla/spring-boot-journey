public class Task11 {
    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            System.out.println("Exception caught.");
        } finally {
            System.out.println("Finally always executes.");
        }
    }
}