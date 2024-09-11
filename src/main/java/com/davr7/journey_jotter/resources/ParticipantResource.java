package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.dtos.ConfirmParticipantDto;
import com.davr7.journey_jotter.dtos.ParticipantDto;
import com.davr7.journey_jotter.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "participants")
public class ParticipantResource {
    @Autowired
    ParticipantService participantServ;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipantDto> handleFindParticipantById(@PathVariable UUID id){
        ParticipantDto participant = participantServ.findParticipantById(id);
        return ResponseEntity.ok().body(participant);
    }

    @PatchMapping(value = "/{id}/confirm")
    public ResponseEntity<ParticipantDto> handleConfirmParticipant(@PathVariable UUID id, @RequestBody ConfirmParticipantDto data){
        ParticipantDto participant = participantServ.confirmParticipant(id, data);
        return ResponseEntity.ok().body(participant);
    }
}
