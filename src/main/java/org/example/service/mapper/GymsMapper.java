package org.example.service.mapper;


import org.example.model.dtos.GymsDTO;
import org.example.model.entities.Classes;
import org.example.model.entities.Gyms;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Mapper
@Component
public class GymsMapper {

    public static GymsDTO toDTO(Gyms gym) {
        GymsDTO dto = new GymsDTO();
        dto.setId(gym.getId());
        dto.setName(gym.getName());
        dto.setLocation(gym.getLocation());
        dto.setProgram(gym.getProgram());
        if (!gym.getClasses().isEmpty()) {
            dto.setClassId(gym.getClasses().get(0).getId());
        }
        return dto;
    }

    public static Gyms toEntity(GymsDTO dto) {
        Gyms gym = new Gyms();
        gym.setId(dto.getId());
        gym.setName(dto.getName());
        gym.setLocation(dto.getLocation());
        gym.setProgram(dto.getProgram());
        if (dto.getClassId() != null) {
            Classes classes = new Classes();
            classes.setId(dto.getClassId());
            gym.setClasses(Collections.singletonList(classes));
        }
        return gym;
    }
}
