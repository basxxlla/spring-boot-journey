public class Product {
    String code;
    double price;

    Product(String code, double price) {
        this.code = code;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        return code.equals(((Product)o).code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
