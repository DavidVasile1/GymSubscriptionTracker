package org.example.controller;

import org.example.model.dtos.SubscriptionDTO;
import org.example.service.SubscriptionService;
import org.example.service.mapper.SubscriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
@RestController
@RequestMapping(value = "/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;

    @Autowired
    SubscriptionController(SubscriptionService subscriptionService, SubscriptionMapper subscriptionMapper) {
        this.subscriptionService = subscriptionService;
        this.subscriptionMapper = subscriptionMapper;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> getSubscriptions() {
        return new ResponseEntity<>(subscriptionService.getAllSubscriptions().stream()
                .map(x -> subscriptionMapper.toDTO(Objects.requireNonNull(x)))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscription(@PathVariable UUID id) {
        return new ResponseEntity<>(subscriptionMapper.toDTO(Objects.requireNonNull(subscriptionService.getSubscription(id).orElse(null))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> postSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        subscriptionService.createSubscription(subscriptionMapper.toEntity(subscriptionDTO));
        return new ResponseEntity<>(subscriptionDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSubscription(@PathVariable UUID id) {
        subscriptionService.deleteSubscription(id);
    }

    @PutMapping
    public ResponseEntity<SubscriptionDTO> editSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        subscriptionService.updateSubscription(subscriptionMapper.toEntity(subscriptionDTO));
        return new ResponseEntity<>(subscriptionDTO, HttpStatus.OK);
    }
}
