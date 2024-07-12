package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.domain.Participant;
import com.davr7.journey_jotter.dtos.ParticipantConfirmDto;
import com.davr7.journey_jotter.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "participant")
public class ParticipantResource {
    @Autowired
    ParticipantService participantServ;

    @GetMapping(value = "/{id}/confirm")
    public ResponseEntity<Participant> handleConfirmParticipant(@PathVariable UUID id, @RequestBody ParticipantConfirmDto data){
        Participant participant = participantServ.confirmParticipant(id, data);
        return ResponseEntity.ok().body(participant);
    }
}
