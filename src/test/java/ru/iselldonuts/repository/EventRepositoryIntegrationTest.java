package ru.iselldonuts.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.iselldonuts.entity.Event;
import ru.iselldonuts.entity.Place;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class EventRepositoryIntegrationTest {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @AfterEach
    public void tearDown() throws Exception {
        eventRepository.deleteAll();
    }

    @Test
    public void shouldSaveAndFetchHelloEvents() throws Exception {
        Place place1 = new Place("Place 1");
        placeRepository.save(place1);

        Event event1 = new Event(
                "Title",
                LocalDate.parse("01.01.2020", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                LocalDate.parse("02.11.2019", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                place1
        );

        Event event2 = new Event(
                "Hello",
                LocalDate.parse("15.10.2020", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                LocalDate.parse("01.11.2019", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                place1
        );

        Event event3 = new Event(
                "Some Text Hello Some Text",
                LocalDate.parse("03.05.2021", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                LocalDate.parse("30.10.2019", DateTimeFormatter.ofPattern("dd.MM.uuuu")),
                place1
        );

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
        List<Event> helloEvents = eventRepository.findAllHello();
        System.out.println(helloEvents);

        assertThat(helloEvents, is(List.of(event2, event3)));
    }
}