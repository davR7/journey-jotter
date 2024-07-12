package com.davr7.journey_jotter.repositories;

import com.davr7.journey_jotter.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {
}
