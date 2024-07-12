package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.ActivityCreateDto;
import com.davr7.journey_jotter.dtos.ParticipantEventDto;
import com.davr7.journey_jotter.dtos.TripCreateDto;
import com.davr7.journey_jotter.services.ActivityService;
import com.davr7.journey_jotter.services.ParticipantService;
import com.davr7.journey_jotter.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "trip")
public class TripResource {
    @Autowired
    TripService tripServ;

    @Autowired
    ParticipantService participantServ;

    @Autowired
    ActivityService activityServ;

    @PostMapping
    public ResponseEntity<Trip> handleCreateTrip(@RequestBody TripCreateDto data){
        Trip newTrip = tripServ.createTrip(data);
        participantServ.registerParticipantsToEvent(data.emailsToInvite(), newTrip);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTrip.getId())
                .toUri();

        return ResponseEntity.created(location).body(newTrip);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Trip> handleFindTripById(@PathVariable UUID id){
        Trip trip = tripServ.findTripById(id);
        return ResponseEntity.ok().body(trip);
    }

    @GetMapping(value = "/{id}/confirm")
    public ResponseEntity<Trip> handleConfirmTrip(@PathVariable UUID id){
        Trip trip = tripServ.confirmTrip(id);
        return ResponseEntity.ok().body(trip);
    }

    @GetMapping(value = "/{id}/participants")
    public ResponseEntity<List<ParticipantEventDto>> handleFindAllParticipantsFromEvent(@PathVariable UUID id){
        List<ParticipantEventDto> participants =  participantServ.findAllParticipantsFromEvent(id);
        return ResponseEntity.ok().body(participants);
    }

    @PostMapping(value = "/{id}/activity")
    public ResponseEntity<Activity> handleCreateActivityToEvent(@PathVariable UUID id, @RequestBody ActivityCreateDto data){
        Activity activity = activityServ.createActivityToEvent(id, data);
        return ResponseEntity.ok().body(activity);
    }
}
