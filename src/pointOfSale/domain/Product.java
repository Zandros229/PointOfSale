package pointOfSale.domain;

public class Product {
    private String name;
    private int id;
    private Money price;

    public Product(String name, int id, Money price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return  name +" price=" + price;
    }
}
