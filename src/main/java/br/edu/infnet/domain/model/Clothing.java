package br.edu.infnet.domain.model;

import javax.persistence.Entity;

@Entity
public class Clothing extends Product {

    private String size;
    private String color;
    private boolean brand;

    public Clothing() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }
}
