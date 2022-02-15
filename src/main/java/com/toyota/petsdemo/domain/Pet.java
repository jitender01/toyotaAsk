package com.toyota.petsdemo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Pet {

    int id;
    String type;
    BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id &&
                Objects.equals(type, pet.type) &&
                Objects.equals(price, pet.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price);
    }
}
