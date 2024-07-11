package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.TripDtoRequest;
import com.davr7.journey_jotter.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "trip")
public class TripResource {
    @Autowired
    TripService tripServ;

    @PostMapping
    public ResponseEntity<Trip> handleCreateTrip(@RequestBody TripDtoRequest data){
        Trip newTrip = tripServ.createTrip(data);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTrip.getId())
                .toUri();

        return ResponseEntity.created(location).body(newTrip);
    }
}
