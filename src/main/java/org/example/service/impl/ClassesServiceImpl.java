package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entities.Classes;
import org.example.repository.ClassesRepository;
import org.example.service.ClassesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService {


    private final ClassesRepository classesRepository;
    @Override
    public void createClass(Classes classes) {
        classesRepository.save(classes);
    }

    @Override
    public Optional <Classes> getClass(UUID id) {
        return classesRepository.findById(id);
    }

    @Override
    public void updateClass(Classes classes) {
        classesRepository.save(classes);

    }

    @Override
    public void deleteClass(UUID id) {
        classesRepository.deleteById(id);

    }

    @Override
    public List<Classes> getAllClassesFromAGym() {
           return classesRepository.findAll();
    }
}
