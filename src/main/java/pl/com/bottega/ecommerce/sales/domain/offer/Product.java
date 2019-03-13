package pl.com.bottega.ecommerce.sales.domain.offer;


import java.util.Date;
import java.util.Objects;

public class Product {

    private String productId;
    private Money productPrice;
    private String productName;
    private Date productSnapshotDate;
    private String productType;

    public Product(String productId, Money productPrice, String productName, Date productSnapshotDate, String productType) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Money getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Money productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }



    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productPrice, product.productPrice) && Objects.equals(
                productName, product.productName) && Objects.equals(productSnapshotDate, product.productSnapshotDate) && Objects.equals(
                productType, product.productType);
    }

    @Override public int hashCode() {
        return Objects.hash(productId, productPrice, productName, productSnapshotDate, productType);
    }
}
