package org.example.service;

import org.example.model.entities.Members;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MembersService {
    void createMember(Members member);
    Optional<Members> getMember(UUID id);
    void updateMember(Members member);
    void deleteMember(UUID id);
    List<Members> getAllMembers();
}
