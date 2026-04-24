public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age); // validation
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0)
            this.age = age;
    }

    // Method to print info
    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
