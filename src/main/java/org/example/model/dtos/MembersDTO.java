package org.example.model.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class MembersDTO  {

    private UUID id;
    private String firstName;
    private String lastName;
    private UUID subscriptionId;
}
