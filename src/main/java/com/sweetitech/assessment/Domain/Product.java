package com.sweetitech.assessment.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Size(min = 3)
    private String name;
    private float price;
    private float profitPercentage;
    private String productType;
    private int soldCount;

    @Transient
    private float totalProfit;

    public Product(String name, float price, float profitPercentage, String productType, int soldCount) {
        this.name = name;
        this.price = price;
        this.profitPercentage = profitPercentage;
        this.productType = productType;
        this.soldCount = soldCount;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(float profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public String getProductType() {
        return productType;
    }

    public float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 &&
                Float.compare(product.profitPercentage, profitPercentage) == 0 &&
                soldCount == product.soldCount &&
                Objects.equals(name, product.name) &&
                productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, profitPercentage, productType, soldCount);
    }
}
