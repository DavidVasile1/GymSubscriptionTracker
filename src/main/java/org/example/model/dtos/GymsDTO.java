package org.example.model.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class GymsDTO {
    private UUID id;
    private String name;
    private String location;
    private String program;
    private UUID classId;

}
