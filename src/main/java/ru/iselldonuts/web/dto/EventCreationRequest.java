package ru.iselldonuts.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.iselldonuts.entity.Place;

import java.time.LocalDate;

public class EventCreationRequest {
    private String title;

    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate date;

    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate createdAt;

    private long placeId;

    public EventCreationRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public long getPlaceId() {
        return placeId;
    }
}