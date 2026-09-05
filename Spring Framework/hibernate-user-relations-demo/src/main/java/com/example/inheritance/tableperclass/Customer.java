package com.example.inheritance.tableperclass;

import javax.persistence.*;

@Entity
@Table(name = "customer_tpc")
public class Customer extends Person {
    private double discountRate;

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
}
