package ru.iselldonuts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "title can't be empty")
    private String title;

    @Column
    private LocalDate date;

    @Column
    private LocalDate createdAt;

    @ManyToOne
    private Place place;

    public Event() {
    }

    public Event(
            @NotNull(message = "title can't be empty") String title,
            LocalDate date,
            LocalDate createdAt,
            Place place) {
        this.title = title;
        this.date = date;
        this.createdAt = createdAt;
        this.place = place;
    }

    public Long getId() {
        return id;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
