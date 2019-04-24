package pointOfSale.domain;

import java.util.Objects;

public class Money {
    private Double amount;
    private Currency courency;

    public Money(Double amount, Currency courency) {
        this.amount = amount;
        this.courency = courency;
    }

    public Double getAmount() {
        return amount;
    }

    public Currency getCourency() {
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

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCourency(Currency courency) {
        this.courency = courency;
    }
}
