//Composition
class Engine {
    void start() {
        System.out.println("Engine starts");
    }
}

class CarVer2 {
    private Engine engine = new Engine();

    void startCar() {
        engine.start();
    }
}
