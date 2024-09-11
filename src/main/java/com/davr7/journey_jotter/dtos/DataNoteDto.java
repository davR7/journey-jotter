package com.davr7.journey_jotter.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record NoteResponseDto(UUID id, String title, String description, String url) {
}
