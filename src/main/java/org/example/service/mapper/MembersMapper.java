package org.example.service.mapper;

import org.example.model.dtos.MembersDTO;
import org.example.model.entities.Members;
import org.example.model.entities.Subscription;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public class MembersMapper {

    public static MembersDTO toDTO(Members members) {
        MembersDTO dto = new MembersDTO();
        dto.setId(members.getId());
        dto.setFirstName(members.getFirstName());
        dto.setLastName(members.getLastName());
        if (members.getSubscription() != null) {
            dto.setSubscriptionId(members.getSubscription().getId());
        }
        return dto;
    }

    public static Members toEntity(MembersDTO dto) {
        Members members = new Members();
        members.setId(dto.getId());
        members.setFirstName(dto.getFirstName());
        members.setLastName(dto.getLastName());
        if (dto.getSubscriptionId() != null) {
            Subscription subscription = new Subscription();
            subscription.setId(dto.getSubscriptionId());
            members.setSubscription(subscription);
        }
        return members;
    }
}
