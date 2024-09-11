package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.CreateActivityDto;
import com.davr7.journey_jotter.dtos.ActivityDto;
import com.davr7.journey_jotter.dtos.DataActivityDto;
import com.davr7.journey_jotter.dtos.TripDto;
import com.davr7.journey_jotter.repositories.ActivityRepository;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
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

    public DataActivityDto createActivityToTrip(CreateActivityDto dto, UUID tripId) {
        TripDto tripDto = tripServ.findTripById(tripId);
        Activity newActivity = CreateActivityDto.toActivity(dto, tripDto);
        return DataActivityDto.convert(activityRepo.save(newActivity));
    }

    public List<ActivityDto> findActivitiesFromTrip(UUID tripId) {
        if (!tripServ.checkIfTripExists(tripId)){
            throw new TripNotFoundException();
        }

        return activityRepo.findByTripId(tripId).stream().map(a ->
                new ActivityDto(a.getId(), a.getTitle(), a.getOccursAt())).toList();
    }
}
