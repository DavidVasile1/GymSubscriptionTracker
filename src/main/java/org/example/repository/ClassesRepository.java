package org.example.repository;

import org.example.model.entities.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassesRepository extends JpaRepository<Classes, UUID> {
}
