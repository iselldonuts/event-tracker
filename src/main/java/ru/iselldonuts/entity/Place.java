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

    public Place(List<Event> events, String address) {
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

    public void addEvent(Event event) {
        events.add(event);
        event.setPlace(this);
    }

    public void removeEvent(Event event) {
        events.remove(event);
        event.setPlace(null);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
