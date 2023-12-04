package org.example.service.mapper;


import org.example.model.dtos.SubscriptionDTO;
import org.example.model.entities.Classes;
import org.example.model.entities.Members;
import org.example.model.entities.Subscription;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SubscriptionMapper {

    public static SubscriptionDTO toDTO(Subscription subscription) {
        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setId(subscription.getId());
        dto.setStartDate(subscription.getStartDate());
        dto.setEndDate(subscription.getEndDate());

        if (subscription.getMember() != null) {
            dto.setMemberId(subscription.getMember().getId());
        }

        if (subscription.getClasses() != null) {
            List<UUID> classIds = subscription.getClasses().stream()
                    .map(Classes::getId)
                    .collect(Collectors.toList());
            dto.setClassesId(classIds);
        }

        return dto;
    }

    public static Subscription toEntity(SubscriptionDTO dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setStartDate(dto.getStartDate());
        subscription.setEndDate(dto.getEndDate());

        if (dto.getMemberId() != null) {
            Members member = new Members();
            member.setId(dto.getMemberId());
            subscription.setMember(member);
        }

        if (dto.getClassesId() != null) {
            List<Classes> classes = dto.getClassesId().stream()
                    .map(id -> {
                        Classes c = new Classes();
                        c.setId(id);
                        return c;
                    })
                    .collect(Collectors.toList());
            subscription.setClasses(classes);
        }

        return subscription;
    }
}
