package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.TripDtoRequest;
import com.davr7.journey_jotter.repositories.TripRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepo;

    public Trip createTrip(TripDtoRequest data) {
        Trip newTrip = new Trip();
        BeanUtils.copyProperties(data, newTrip, "startsAt", "endsAt", "emailsToInvite");
        newTrip.setIsConfirmed(false);
        newTrip.setStartsAt(LocalDateTime.parse(data.startsAt(), DateTimeFormatter.ISO_DATE_TIME));
        newTrip.setEndsAt(LocalDateTime.parse(data.endsAt(), DateTimeFormatter.ISO_DATE_TIME));
        return tripRepo.save(newTrip);
    }
}
