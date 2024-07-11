package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "participant")
public class ParticipantResource {
    @Autowired
    ParticipantService participantServ;
}
