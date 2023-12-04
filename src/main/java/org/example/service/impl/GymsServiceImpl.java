package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entities.Gyms;
import org.example.repository.GymsRepository;
import org.example.service.GymsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class GymsServiceImpl implements GymsService {

    public final GymsRepository gymsRepository;
    @Override
    public void createGym(Gyms gyms) {
        gymsRepository.save(gyms);
    }

    @Override
    public Optional<Gyms> getGym(UUID id) {
        return gymsRepository.findById(id);
    }

    @Override
    public void updateGyms(Gyms gyms) {
        gymsRepository.save(gyms);

    }

    @Override
    public void deleteGyms(UUID id) {
        gymsRepository.deleteById(id);

    }

    @Override
    public List<Gyms> getAllGyms() {

        return gymsRepository.findAll();
    }
}
