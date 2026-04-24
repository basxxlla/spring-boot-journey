import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, 80));
        students.add(new Student(2, 40));

        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("Total students: " + Student.count);
        System.out.println("---------------------------------------------");

        // Polymorphism
        Animal a = new Dog("Max");
        a.sound(); // runtime polymorphism
        System.out.println("---------------------------------------------");

        Animal c = new Cat("Luna");
        c.sound();

        System.out.println("---------------------------------------------");

        // Interface reference
        Payment p = new CreditCardPayment();
        p.pay(100);

    }
}