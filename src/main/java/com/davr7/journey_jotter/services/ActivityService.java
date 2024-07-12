package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepo;
}
