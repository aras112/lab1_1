/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    Product product;

    private int quantity;

    private BigDecimal totalCost;

    private String currency;

    // discount
    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

        this.totalCost = product.getProductPrice().getCost().multiply(new BigDecimal(quantity));

        if (discount != null) {
            this.totalCost = this.getTotalCost().subtract(discount.getDiscount().getCost());
        }
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
    

    public Product getProduct() {
        return product;
    }

    /**
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if (product != other.product) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;

        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
