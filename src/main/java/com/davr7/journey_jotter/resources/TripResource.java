package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.*;
import com.davr7.journey_jotter.services.ActivityService;
import com.davr7.journey_jotter.services.NoteService;
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

    @Autowired
    NoteService noteServ;

    @PostMapping
    public ResponseEntity<Trip> handleCreateTrip(@RequestBody TripCreateDto data){
        Trip newTrip = tripServ.createTrip(data);
        participantServ.registerParticipantsToTrip(data.emailsToInvite(), newTrip);

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

    @PatchMapping(value = "/{id}/confirm")
    public ResponseEntity<Trip> handleConfirmTrip(@PathVariable UUID id){
        Trip trip = tripServ.confirmTrip(id);
        return ResponseEntity.ok().body(trip);
    }

    @GetMapping(value = "/{id}/participants")
    public ResponseEntity<List<ParticipantEventDto>> handleFindAllParticipantsFromTrip(@PathVariable UUID id){
        List<ParticipantEventDto> participants =  participantServ.findAllParticipantsFromTrip(id);
        return ResponseEntity.ok().body(participants);
    }

    @PostMapping(value = "/{id}/activity")
    public ResponseEntity<Activity> handleCreateActivityToEvent(@PathVariable UUID id, @RequestBody ActivityCreateDto data){
        Activity activity = activityServ.createActivityToTrip(id, data);
        return ResponseEntity.ok().body(activity);
    }

    @GetMapping(value = "/{id}/activities")
    public ResponseEntity<List<ActivityResponseDto>> handleFindActivitiesToEvent(@PathVariable UUID id){
        List<ActivityResponseDto> activities = activityServ.findActivitiesFromTrip(id);
        return ResponseEntity.ok().body(activities);
    }

    @PostMapping(value = "/{id}/note")
    public ResponseEntity<Note> handleCreateNoteToEvent(@PathVariable UUID id, @RequestBody NoteCreateDto data){
        Note note = noteServ.createNoteToTrip(id, data);
        return ResponseEntity.ok().body(note);
    }

    @GetMapping(value = "/{id}/notes")
    public ResponseEntity<List<NoteResponseDto>> handleFindNotesToEvent(@PathVariable UUID id){
        List<NoteResponseDto> notes = noteServ.findNotesFromTrip(id);
        return ResponseEntity.ok().body(notes);
    }
}
