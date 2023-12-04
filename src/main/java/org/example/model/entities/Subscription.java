package org.example.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne
    private Members member;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "subscriptions")
    private List<Classes> classes;



}
