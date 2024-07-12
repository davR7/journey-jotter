package com.davr7.journey_jotter.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityResponseDto(UUID id, String title, LocalDateTime occursAt) {
}
