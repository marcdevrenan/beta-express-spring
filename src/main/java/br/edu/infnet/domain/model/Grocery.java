package br.edu.infnet.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Grocery extends Product {

    private String distributor;
    private float weight;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validity;

    public Grocery() {
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }
}
