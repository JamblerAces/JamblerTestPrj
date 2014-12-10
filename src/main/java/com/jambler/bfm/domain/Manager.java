package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manager {


    private Long id;
    private String name;

    public Manager() {
    }

    public Manager(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager that = (Manager) o;

        return Objects.equal(this.name, that.name) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, id);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("id", id)
                .toString();
    }


    private Collection<CustomerOrder> orders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    public Collection<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<CustomerOrder> orders) {
        this.orders = orders;
    }
}
