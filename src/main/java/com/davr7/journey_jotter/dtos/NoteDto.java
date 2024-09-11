package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Trip;

import java.util.UUID;

public record NoteDto(UUID id, String title, String description, String url) {
}
