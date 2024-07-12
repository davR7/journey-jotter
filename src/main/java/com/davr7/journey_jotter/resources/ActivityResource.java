package com.davr7.journey_jotter.resources;

import com.davr7.journey_jotter.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "activity")
public class ActivityResource {
    @Autowired
    ActivityService activityServ;
}
