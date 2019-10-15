package ru.iselldonuts.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    @Column
    private String address;

    public Place() {
    }

    public Place(Long id, List<Event> events, String address) {
        this.id = id;
        this.events = events;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
