package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepo;
}
