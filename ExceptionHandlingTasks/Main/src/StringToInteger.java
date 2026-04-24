import java.util.Scanner;

public class StringToInteger {
    public void stringToInteger(){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            String input = sc.nextLine();

            int num = Integer.parseInt(input);
            System.out.println("Converted: " + num);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }
}
