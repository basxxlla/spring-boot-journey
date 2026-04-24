public class ProceduralVsOOP {
    //Procedural
    double calculateTotal(double price, int qty) {
        return price * qty;
    }
}
//OOP
class Product {
    double price;
    int quantity;

    double getTotal() {
        return price * quantity;
    }
}
