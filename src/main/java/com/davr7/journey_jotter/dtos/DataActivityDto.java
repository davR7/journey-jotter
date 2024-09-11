package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Activity;
import com.davr7.journey_jotter.domain.Trip;

import java.util.UUID;

public record DataActivityDto(UUID id) {
    public static DataActivityDto convert(Activity activity){
        return new DataActivityDto(activity.getId());
    }
}
