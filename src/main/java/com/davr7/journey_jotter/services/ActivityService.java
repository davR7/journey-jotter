package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.ActivityCreateDto;
import com.davr7.journey_jotter.dtos.ActivityResponseDto;
import com.davr7.journey_jotter.repositories.ActivityRepository;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepo;

    @Autowired
    TripService tripServ;

    public Activity createActivityToTrip(UUID id, ActivityCreateDto data) {
        Trip trip = tripServ.findTripById(id);

        Activity newActivity = new Activity();
        newActivity.setTitle(data.title());
        newActivity.setOccursAt(DateUtils.parseIsoDateTime(data.occursAt()));
        newActivity.setTrip(trip);
        return activityRepo.save(newActivity);
    }

    public List<ActivityResponseDto> findActivitiesFromTrip(UUID tripId) {
        if (!tripServ.checkIfTripExists(tripId)){
            throw new TripNotFoundException();
        }

        return activityRepo.findByTripId(tripId).stream().map(a ->
                new ActivityResponseDto(a.getId(), a.getTitle(), a.getOccursAt())).toList();
    }
}
