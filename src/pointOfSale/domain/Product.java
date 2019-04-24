package pointOfSale.domain;

public class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  name +" price=" + price;
    }
}
