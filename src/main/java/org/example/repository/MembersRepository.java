package org.example.repository;

import org.example.model.entities.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MembersRepository extends JpaRepository<Members, UUID> {
}
