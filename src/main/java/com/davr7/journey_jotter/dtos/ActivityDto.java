package com.davr7.journey_jotter.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityDto(UUID id, String title, LocalDateTime occursAt) {
}
