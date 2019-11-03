package ru.iselldonuts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.iselldonuts.entity.Place;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    List<Place> findByAddress(String address);

    List<Place> findAll();

    Place findById(long id);
}
