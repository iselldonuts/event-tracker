package ru.iselldonuts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.iselldonuts.entity.Event;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByTitle(String title);

    List<Event> findAll();

    Event findById(long id);
}