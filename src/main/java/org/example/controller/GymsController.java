package org.example.controller;

import org.example.model.dtos.GymsDTO;
import org.example.model.entities.Gyms;
import org.example.service.GymsService;
import org.example.service.mapper.GymsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/gyms")
public class GymsController {
    private final GymsService gymsService;
    private final GymsMapper gymsMapper;

    @Autowired
    GymsController(GymsService gymsService, GymsMapper gymsMapper) {
        this.gymsService = gymsService;
        this.gymsMapper = gymsMapper;
    }

    @GetMapping
    public ResponseEntity<List<GymsDTO>> getGyms() {
        return new ResponseEntity<>(gymsService.getAllGyms().stream()
                .map(x -> gymsMapper.toDTO(Objects.requireNonNull(x)))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GymsDTO> getGym(@PathVariable UUID id) {
        return new ResponseEntity<>(gymsMapper.toDTO(Objects.requireNonNull(gymsService.getGym(id).orElse(null))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GymsDTO> postGym(@RequestBody GymsDTO gymsDTO) {
        gymsService.createGym(gymsMapper.toEntity(gymsDTO));
        return new ResponseEntity<>(gymsDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGym(@PathVariable UUID id) {
        gymsService.deleteGyms(id);
    }

    @PutMapping
    public ResponseEntity<GymsDTO> editGym(@RequestBody GymsDTO gymsDTO) {
        gymsService.updateGyms(gymsMapper.toEntity(gymsDTO));
        return new ResponseEntity<>(gymsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<GymsDTO>> searchGyms(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "location", required = true) String location) {
        List<Gyms> gyms = gymsService.getAllGyms();
        List<GymsDTO> gymsDTOs = gyms.stream()
                .filter(x-> Objects.equals(x.getLocation(), location))
                .filter(x-> Objects.equals(x.getName(), name))
                .map(GymsMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gymsDTOs, HttpStatus.OK);
    }
}
