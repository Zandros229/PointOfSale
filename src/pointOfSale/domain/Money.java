package pointOfSale.domain;

import java.util.Objects;

public class Money {
    private Double amount;
    private String courency;

    public Money(Double amount, String courency) {
        this.amount = amount;
        this.courency = courency;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCourency() {
        return courency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Objects.equals(getAmount(), money.getAmount()) &&
                Objects.equals(getCourency(), money.getCourency());
    }

}
