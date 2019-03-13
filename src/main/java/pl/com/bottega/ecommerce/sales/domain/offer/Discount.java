package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String discountCause;

    private Money discount;


    public Discount(String discountCause, Money discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public Money getDiscount() {
        return discount;
    }

    public void setDiscount(Money discount) {
        this.discount = discount;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount1 = (Discount) o;
        return Objects.equals(discountCause, discount1.discountCause) && Objects.equals(discount, discount1.discount);
    }

    @Override public int hashCode() {
        return Objects.hash(discountCause, discount);
    }
}
