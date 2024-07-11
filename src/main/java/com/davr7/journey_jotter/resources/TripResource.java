package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "trip")
public class TripResource {
    @Autowired
    TripService tripServ;
}
