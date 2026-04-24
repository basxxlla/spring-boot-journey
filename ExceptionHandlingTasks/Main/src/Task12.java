public class Task12 {
    public static void main(String[] args) {

        try {
            try {
                int x = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Arithmetic error.");
                throw e; // rethrow to outer
            }

        } catch (Exception e) {
            System.out.println("Outer catch: Exception handled.");
        }
    }
}