package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;
    private String mainDomen;

    public Shop() {
    }

    public Shop(String shopName, String mainDomen) {
        this.shopName = shopName;
        this.mainDomen = mainDomen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMainDomen() {
        return mainDomen;
    }

    public void setMainDomen(String mainDomen) {
        this.mainDomen = mainDomen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop that = (Shop) o;

        return Objects.equal(this.shopName, that.shopName) &&
                Objects.equal(this.mainDomen, that.mainDomen) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shopName, mainDomen, id);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shopName", shopName)
                .add("mainDomen", mainDomen)
                .add("id", id)
                .toString();
    }
}
