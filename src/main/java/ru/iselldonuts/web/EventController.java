package ru.iselldonuts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.iselldonuts.entity.Event;
import ru.iselldonuts.repository.EventRepository;
import ru.iselldonuts.web.dto.EventCreationRequest;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // curl -d '{"title":"test"}' -H "Content-Type: application/json" -X POST http://localhost:8080/events
    @PostMapping
    public @ResponseBody
    Event createEvent(@RequestBody EventCreationRequest eventCreationRequest) {
        Event event = new Event(
                eventCreationRequest.getTitle(),
                eventCreationRequest.getDate(),
                eventCreationRequest.getCreatedAt(),
                eventCreationRequest.getLocation()
        );
        eventRepository.save(event);

        return event;
    }

    // curl -X GET http://localhost:8080/events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}