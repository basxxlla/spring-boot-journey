public class NullPointer {
    public void printUpper(String str) {
        try {
            System.out.println(str.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("String is null.");
        }
    }
}
