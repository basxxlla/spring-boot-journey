package com.example.relationships.customerorder;

import javax.persistence.*;
import java.time.LocalDate;

// Relationship: MANY-TO-ONE (many orders belong to one customer)
// Note: named CustomerOrder because "Order" is a reserved SQL keyword in most DBs.
@Entity
public class CustomerOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
