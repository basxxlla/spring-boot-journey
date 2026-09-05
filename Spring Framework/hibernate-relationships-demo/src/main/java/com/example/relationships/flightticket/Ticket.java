package com.example.relationships.flightticket;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
}
