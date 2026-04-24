public class MultipleCatchBlocks {
    public void multipleCatchBlocks(){
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException

            int x = 10 / 0; // ArithmeticException

        } catch (NullPointerException e) {
            System.out.println("Null pointer occurred.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error occurred.");
        }
    }
}
