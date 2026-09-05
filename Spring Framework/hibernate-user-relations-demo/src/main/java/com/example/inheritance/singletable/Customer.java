package com.example.inheritance.singletable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends Person {
    private double discountRate;

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
}
