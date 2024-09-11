package com.davr7.journey_jotter.resources;

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
@RequestMapping(value = "trips")
public class TripResource {
    @Autowired
    TripService tripServ;

    @Autowired
    ParticipantService participantServ;

    @Autowired
    ActivityService activityServ;

    @Autowired
    NoteService noteServ;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TripDto> handleFindTripById(@PathVariable UUID id){
        TripDto trip = tripServ.findTripById(id);
        return ResponseEntity.ok().body(trip);
    }

    @GetMapping(value = "/{id}/participants")
    public ResponseEntity<List<ParticipantDto>> handleFindAllParticipantsFromTrip(@PathVariable UUID id){
        List<ParticipantDto> participants =  participantServ.findAllParticipantsFromTrip(id);
        return ResponseEntity.ok().body(participants);
    }

    @PostMapping(value = "/{id}/activities")
    public ResponseEntity<DataActivityDto> handleCreateActivityToEvent(@PathVariable UUID id, @RequestBody CreateActivityDto dto){
        DataActivityDto newActivity = activityServ.createActivityToTrip(dto, id);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newActivity.id())
                .toUri();

        return ResponseEntity.created(location).body(newActivity);
    }

    @GetMapping(value = "/{id}/activities")
    public ResponseEntity<List<ActivityDto>> handleFindActivitiesToEvent(@PathVariable UUID id){
        List<ActivityDto> activities = activityServ.findActivitiesFromTrip(id);
        return ResponseEntity.ok().body(activities);
    }

    @PostMapping(value = "/{id}/notes")
    public ResponseEntity<DataNoteDto> handleCreateNoteToEvent(@PathVariable UUID id, @RequestBody CreateNoteDto data){
        DataNoteDto newNote = noteServ.createNoteToTrip(data, id);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newNote.id())
                .toUri();

        return ResponseEntity.created(location).body(newNote);
    }

    @GetMapping(value = "/{id}/notes")
    public ResponseEntity<List<NoteDto>> handleFindNotesToEvent(@PathVariable UUID id){
        List<NoteDto> notes = noteServ.findNotesFromTrip(id);
        return ResponseEntity.ok().body(notes);
    }
}
