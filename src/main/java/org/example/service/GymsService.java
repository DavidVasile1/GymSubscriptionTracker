package org.example.service;

import org.example.model.entities.Gyms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GymsService {
    void createGym(Gyms gyms);
    Optional<Gyms> getGym(UUID id);
    void updateGyms(Gyms gyms);
    void deleteGyms(UUID id);

    List<Gyms> getAllGyms();
}
