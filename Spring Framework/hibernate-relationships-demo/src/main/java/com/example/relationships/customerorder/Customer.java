package com.example.relationships.customerorder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Relationship: ONE-TO-MANY (one customer places many orders)
@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerOrder> orders = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<CustomerOrder> getOrders() { return orders; }
    public void setOrders(List<CustomerOrder> orders) { this.orders = orders; }
}
