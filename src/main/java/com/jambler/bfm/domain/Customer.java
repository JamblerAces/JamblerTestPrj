package com.jambler.bfm.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

        Customer that = (Customer) o;

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
}
