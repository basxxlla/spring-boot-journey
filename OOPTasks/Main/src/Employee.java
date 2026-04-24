public class Employee {
    private final int employeeId;
    private String password;

    public Employee(int id, String password) {
        this.employeeId = id;
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
