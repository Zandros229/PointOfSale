package pointOfSale.domain;

import java.util.Objects;

public class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " price=" + price.getAmount() + " " + price.getCourency();
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) &&
                Objects.equals(getPrice(), product.getPrice());
    }
}
