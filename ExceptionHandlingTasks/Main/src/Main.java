import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NullPointer np = new NullPointer();
        np.printUpper(null);

        System.out.println("------------------------------------------------------");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above.");
            }

            System.out.println("Access granted.");

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------------------");

        try {
            Task10.readFile();
        } catch (IOException e) {
            System.out.println("IO Exception occurred.");
        }

    }
}