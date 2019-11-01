package ru.iselldonuts;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import ru.iselldonuts.repository.EventRepository;
import ru.iselldonuts.repository.PlaceRepository;


@TestConfiguration
@ComponentScan(basePackages = "ru.iselldonuts")
public class MockConfig {

    @MockBean
    private PlaceRepository placeRepository;


    @MockBean
    private EventRepository eventRepository;
}