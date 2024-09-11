package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.User;

import java.util.UUID;

public record DataNoteDto(UUID id) {
    public static DataNoteDto convert(Note note){
        return new DataNoteDto(note.getId());
    }
}
