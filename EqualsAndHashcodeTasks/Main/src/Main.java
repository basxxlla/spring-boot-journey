import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Before overriding equals()
        Person p1 = new Person(1, "Ali");
        Person p2 = new Person(1, "Ali");

        System.out.println(p1.equals(p2)); //False

        //After overriding equals() but not hashCode() -> Objects are equa BUT they go to different hash buckets
        System.out.println(p1.equals(p2)); //True

        //Test WITHOUT overrides
        Set<Person> set = new HashSet<>();

        set.add(new Person(1, "Ali"));
        set.add(new Person(1, "Ali"));

        System.out.println(set.size()); // 2

        //AFTER overriding equals + hashCode
        System.out.println(set.size()); //1


        set.add(new Person(1, "A"));
        set.add(new Person(2, "B"));
        set.add(new Person(1, "C")); // duplicate id
        set.add(new Person(3, "D"));

        System.out.println(set.size());

        //Use Person as Key
        Map<Person, String> map = new HashMap<>();

        map.put(new Person(1, "Ali"), "Employee");
        map.put(new Person(1, "Ali"), "Manager");

        System.out.println(map.size()); //size = 1

        Person key = new Person(1, "Ali");

        System.out.println(map.get(key));

        //Modify Key After Insert

        Person p = new Person(1, "Ali");
        map.put(p, "Employee");
        p.id = 2;
        System.out.println(map.get(p)); //null

        //Car as HashMap Key
        Map<Car, String> parking = new HashMap<>();

        Car c1 = new Car("123", "Red");
        parking.put(c1, "Slot A");

        Car c2 = new Car("123", "Blue");
        System.out.println(parking.get(c2)); // it works

    }
}