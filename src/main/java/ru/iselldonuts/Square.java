package ru.iselldonuts;

public class Square {
    private final long id;
    private final Double content;

    public Square(long id, Double content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Double getContent() {
        return content;
    }
}
