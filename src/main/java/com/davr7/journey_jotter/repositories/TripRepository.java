package com.davr7.journey_jotter.repositories;

import com.davr7.journey_jotter.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
