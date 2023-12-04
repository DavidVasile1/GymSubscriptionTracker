package org.example.model.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ClassesDTO {
    private UUID id;
    private String name;
    private String trainerName;
    private String program;
    private UUID gymId;
}
