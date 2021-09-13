package br.edu.infnet.domain.model;

import javax.persistence.Entity;

@Entity
public class Electronic extends Product {

    private String manufacturer;
    private int voltage;
    private boolean national;

    public Electronic() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public boolean isNational() {
        return national;
    }

    public void setNational(boolean national) {
        this.national = national;
    }
}
