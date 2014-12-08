package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemUrl;

    @OneToOne
    private Shop shop;
    private String color;
    private String size;
    private int amount;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String itemUrl, Shop shop, double price, int amount) {
        this.itemUrl = itemUrl;
        this.shop = shop;
        this.price = price;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem that = (OrderItem) o;

        return Objects.equal(this.itemUrl, that.itemUrl) &&
                Objects.equal(this.shop, that.shop) &&
                Objects.equal(this.color, that.color) &&
                Objects.equal(this.size, that.size) &&
                Objects.equal(this.amount, that.amount) &&
                Objects.equal(this.price, that.price) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemUrl, shop, color, size, amount, price,
                id);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("itemUrl", itemUrl)
                .add("shop", shop)
                .add("color", color)
                .add("size", size)
                .add("amount", amount)
                .add("price", price)
                .add("id", id).
                        omitNullValues()
                .toString();
    }
}
