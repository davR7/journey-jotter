package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.TripDtoRequest;
import com.davr7.journey_jotter.repositories.TripRepository;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepo;

    public Trip createTrip(TripDtoRequest data) {
        Trip newTrip = new Trip();
        BeanUtils.copyProperties(data, newTrip, "startsAt", "endsAt", "emailsToInvite");
        newTrip.setIsConfirmed(false);
        newTrip.setStartsAt(DateUtils.parseIsoDateTime(data.startsAt()));
        newTrip.setEndsAt(DateUtils.parseIsoDateTime(data.endsAt()));
        return tripRepo.save(newTrip);
    }

    public Trip findTripById(UUID id){
        Optional<Trip> trip = tripRepo.findById(id);
        return trip.orElseThrow(TripNotFoundException::new);
    }
}
