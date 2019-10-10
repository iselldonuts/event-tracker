package ru.iselldonuts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "title can't be empty")
    private String title;

    public Event() {
    }

    public Event(@NotNull(message = "title can't be empty") String title) {
        this.title = title;
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
}
