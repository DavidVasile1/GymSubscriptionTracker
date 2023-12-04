package org.example.controller;

import org.example.model.dtos.ClassesDTO;
import org.example.service.ClassesService;
import org.example.service.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/classes")
public class ClassesController {
    private final ClassesService classesService;
    private final ClassesMapper classesMapper;

    @Autowired
    ClassesController(ClassesService classesService, ClassesMapper classesMapper) {
        this.classesService = classesService;
        this.classesMapper = classesMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClassesDTO>> getClasses() {
        return new ResponseEntity<>(classesService.getAllClassesFromAGym().stream()
                .map(x -> classesMapper.toDTO(Objects.requireNonNull(x)))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassesDTO> getClass(@PathVariable UUID id) {
        return new ResponseEntity<>(classesMapper.toDTO(Objects.requireNonNull(classesService.getClass(id).orElse(null))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassesDTO> postClass(@RequestBody ClassesDTO classesDTO) {
        classesService.createClass(classesMapper.toEntity(classesDTO));
        return new ResponseEntity<>(classesDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClass(@PathVariable UUID id) {
        classesService.deleteClass(id);
    }

    @PutMapping
    public ResponseEntity<ClassesDTO> editClass(@RequestBody ClassesDTO classesDTO) {
        classesService.updateClass(classesMapper.toEntity(classesDTO));
        return new ResponseEntity<>(classesDTO, HttpStatus.OK);
    }
}
