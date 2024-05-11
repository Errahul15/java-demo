package com.demo.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bus_name", nullable = false)
    private String busName;

    @ManyToMany
    @JoinTable(name = "bus_journey",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_Stops_id"))
    private Set<Bus_Stop> bus_Stops = new LinkedHashSet<>();

    public Set<Bus_Stop> getBus_Stops() {
        return bus_Stops;
    }

    public void setBus_Stops(Set<Bus_Stop> bus_Stops) {
        this.bus_Stops = bus_Stops;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}