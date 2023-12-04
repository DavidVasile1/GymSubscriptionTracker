package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entities.Members;
import org.example.repository.MembersRepository;
import org.example.service.MembersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;
    @Override
    public void createMember(Members member) {
        membersRepository.save(member);
    }

    @Override
    public Optional<Members> getMember(UUID id) {
       return membersRepository.findById(id);
    }

    @Override
    public void updateMember(Members member) {
        membersRepository.save(member);
    }

    @Override
    public void deleteMember(UUID id) {
        membersRepository.deleteById(id);
    }

    @Override
    public List<Members> getAllMembers() {
       return membersRepository.findAll();
    }
}
