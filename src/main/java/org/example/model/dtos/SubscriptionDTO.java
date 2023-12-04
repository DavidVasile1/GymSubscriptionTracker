package org.example.model.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class SubscriptionDTO {

    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID memberId;
    private List<UUID> classesId;

}
