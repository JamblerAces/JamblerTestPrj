package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shopName;
    private String mainDomain;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    @OrderBy("name ASC")
    private Set<ShopItem> items;

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

    public String getMainDomain() {
        return mainDomain;
    }

    public void setMainDomain(String mainDomen) {
        this.mainDomain = mainDomen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop that = (Shop) o;

        return Objects.equal(this.shopName, that.shopName) &&
                Objects.equal(this.mainDomain, that.mainDomain) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shopName, mainDomain, id);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shopName", shopName)
                .add("mainDomen", mainDomain)
                .add("id", id)
                .toString();
    }
}
