package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemUrl;

    @ManyToOne
    private ShopItem item;

    private String color;
    private String size;
    private int amount;
    private double price;

    public ShopItem getItem() {
        return item;
    }

    public void setItem(ShopItem item) {
        this.item = item;
    }

    public long getId() {
        return id;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
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
                Objects.equal(this.color, that.color) &&
                Objects.equal(this.size, that.size) &&
                Objects.equal(this.amount, that.amount) &&
                Objects.equal(this.price, that.price) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemUrl, color, size, amount, price,
                id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("itemUrl", itemUrl)
                .add("color", color)
                .add("size", size)
                .add("amount", amount)
                .add("price", price)
                .add("id", id).
                        omitNullValues()
                .toString();
    }
}
