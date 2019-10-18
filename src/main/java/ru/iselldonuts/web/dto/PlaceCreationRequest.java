package ru.iselldonuts.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.iselldonuts.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class PlaceCreationRequest {
    private String address;
    private List<Event> events = new ArrayList<>();

    public PlaceCreationRequest() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}