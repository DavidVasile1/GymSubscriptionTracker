package org.example.service.mapper;

import org.example.model.dtos.MembersDTO;
import org.example.model.entities.Members;
import org.example.model.entities.Subscription;
import org.springframework.stereotype.Component;

@Component
public class MembersMapper {

    public  MembersDTO toDTO(Members member) {
        MembersDTO membersDTO = new MembersDTO();
        membersDTO.setId(member.getId());
        membersDTO.setFirstName(member.getFirstName());
        membersDTO.setLastName(member.getLastName());
        if (member.getSubscription() != null) {
            membersDTO.setSubscriptionId(member.getSubscription().getId());
        }
        return membersDTO;
    }

    public  Members toEntity(MembersDTO membersDTO) {
        Members member = new Members();
        member.setId(member.getId());
        member.setFirstName(member.getFirstName());
        member.setLastName(member.getLastName());
        if (member.getSubscription() != null) {
            Subscription subscription = new Subscription();
            subscription.setId(member.getSubscription().getId());
            member.setSubscription(subscription);
        }
        return member;
    }
}
