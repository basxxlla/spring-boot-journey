import java.util.Scanner;

public class AccessArrayElement {
    public void accessArrayElement() {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter index: ");
            int index = sc.nextInt();

            System.out.println("Value: " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }
}
