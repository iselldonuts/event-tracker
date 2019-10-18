package ru.iselldonuts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.iselldonuts.entity.Place;
import ru.iselldonuts.repository.PlaceRepository;
import ru.iselldonuts.web.dto.PlaceCreationRequest;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    // curl -d '{"address":"test"}' -H "Content-Type: application/json" -X POST http://localhost:8080/places
    @PostMapping
    public @ResponseBody
    Place createPlace(@RequestBody PlaceCreationRequest placeCreationRequest) {
        Place place = new Place(placeCreationRequest.getAddress());
        placeRepository.save(place);

        return place;
    }

    // curl -X GET http://localhost:8080/places
    @GetMapping
    public List<Place> getAllEvents() {
        return placeRepository.findAll();
    }
}