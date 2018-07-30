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
    @NotNull
    private Float price;
    @NotNull
    private Float profitPercentage;
    @NotNull
    private String productType;
    @NotNull
    private Integer soldCount;

    @Transient
    private float totalProfit;


    public Product() {
    }

    public Product(@NotNull @Size(min = 3) String name, Float price, Float profitPercentage, String productType, Integer soldCount) {
        this.name = name;
        this.price = price;
        this.profitPercentage = profitPercentage;
        this.productType = productType;
        this.soldCount = soldCount;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(Float profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    public float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(profitPercentage, product.profitPercentage) &&
                Objects.equals(productType, product.productType) &&
                Objects.equals(soldCount, product.soldCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, profitPercentage, productType, soldCount);
    }
}
