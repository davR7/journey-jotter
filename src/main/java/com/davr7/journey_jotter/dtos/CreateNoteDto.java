package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.domain.User;

public record CreateNoteDto(String title, String description, String url) {
    public static Note toNote(CreateNoteDto dto, TripDto tripDto){
        return new Note(null, dto.title, dto.description, dto.url(), new Trip(tripDto.id()));
    }
}
