//Dependency Injection
public class Service {
    void serve() {
        System.out.println("Service running");
    }
}

class Client {
    private Service service;

    public Client(Service service) {
        this.service = service;
    }
}
