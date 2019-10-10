package ru.iselldonuts.web.dto;

public class EventCreationRequest {
    private String title;

    public EventCreationRequest() {
    }

    public EventCreationRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}