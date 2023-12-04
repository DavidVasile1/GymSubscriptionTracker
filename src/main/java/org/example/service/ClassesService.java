package org.example.service;

import org.example.model.entities.Classes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassesService {

    void createClass(Classes classes);
    Optional <Classes> getClass(UUID id);
    void updateClass(Classes classes);
    void deleteClass(UUID id);

    List<Classes> getAllClassesFromAGym();

}
