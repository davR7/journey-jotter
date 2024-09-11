package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Trip;

public record CreateActivityDto(String title, String occursAt) {
    public static Activity toActivity(CreateActivityDto dto, TripDto tripDto){
        return new Activity(null, dto.title, DateUtils.parseIsoDateTime(dto.occursAt()), new Trip(tripDto.id()));
    }
}
