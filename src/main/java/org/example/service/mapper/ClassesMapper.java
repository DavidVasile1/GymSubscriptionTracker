package org.example.service.mapper;


import org.example.model.dtos.ClassesDTO;
import org.example.model.entities.Classes;
import org.example.model.entities.Gyms;
import org.springframework.stereotype.Component;

@Component
public class ClassesMapper {

    public static ClassesDTO toDTO(Classes classes) {
        ClassesDTO dto = new ClassesDTO();
        dto.setId(classes.getId());
        dto.setName(classes.getName());
        dto.setTrainerName(classes.getTrainerName());
        dto.setProgram(classes.getProgram());
        if (classes.getGym() != null) {
            dto.setGymId(classes.getGym().getId());
        }
        return dto;
    }

    public static Classes toEntity(ClassesDTO dto) {
        Classes classes = new Classes();
        classes.setId(dto.getId());
        classes.setName(dto.getName());
        classes.setTrainerName(dto.getTrainerName());
        classes.setProgram(dto.getProgram());
        if (dto.getGymId() != null) {
            Gyms gym = new Gyms();
            gym.setId(dto.getGymId());
            classes.setGym(gym);
        }
        return classes;
    }
}
