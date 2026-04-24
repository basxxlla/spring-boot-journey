public class Student {
    private int id;
    private double grade;

    static String schoolName = "ABC School";
    static int count = 0; // count Students

    public Student(int id, double grade) {
        this.id = id;
        this.grade = grade;
        count++;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100)
            this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    // See if the student pass
    public boolean isPassed() {
        return grade >= 50;
    }

    // override toString
    @Override
    public String toString() {
        return "ID: " + id + ", Grade: " + grade;
    }
}
