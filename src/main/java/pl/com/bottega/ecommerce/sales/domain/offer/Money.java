package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal cost;
    private String currency;

    public Money(BigDecimal cost, String currency) {
        this.cost = cost;
        this.currency = currency;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return Objects.equals(cost, money.cost) && Objects.equals(currency, money.currency);
    }

    @Override public int hashCode() {
        return Objects.hash(cost, currency);
    }
}
