package org.example.repository;

import org.example.model.entities.Gyms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GymsRepository extends JpaRepository<Gyms, UUID> {
}
