package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.dtos.*;
import com.davr7.journey_jotter.services.ParticipantService;
import com.davr7.journey_jotter.services.TripService;
import com.davr7.journey_jotter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "users")
public class UserResource {
    @Autowired
    UserService userServ;

    @Autowired
    TripService tripServ;

    @Autowired
    ParticipantService participantServ;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> handleFindUserById(@PathVariable UUID id){
        UserDto user = userServ.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<DataUserDto> handleCreateUser(@RequestBody CreateUserDto data){
        DataUserDto newUser = userServ.createUser(data);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.id())
                .toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @PostMapping(value = "/{userId}/trips")
    public ResponseEntity<DataTripDto> handleCreateTrip(@PathVariable UUID userId, @RequestBody CreateTripDto data){
        DataTripDto newTrip = tripServ.createTrip(data, userId);
        participantServ.registerParticipantsToTrip(data.emailsToInvite(), newTrip);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTrip.id())
                .toUri();

        return ResponseEntity.created(location).body(newTrip);
    }

    @PatchMapping(value = "/{userId}/trips/{tripId}/confirm")
    public ResponseEntity<TripDto> handleConfirmTrip(@PathVariable UUID userId, @PathVariable UUID tripId){
        TripDto trip = tripServ.confirmTrip(userId, tripId);
        return ResponseEntity.ok().body(trip);
    }
}
