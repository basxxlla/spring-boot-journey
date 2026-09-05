package com.example.inheritance.joined;

import javax.persistence.*;

@Entity
@Table(name = "customer_joined")
@PrimaryKeyJoinColumn(name = "person_id")
public class Customer extends Person {
    private double discountRate;

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
}
