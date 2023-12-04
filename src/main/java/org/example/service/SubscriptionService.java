package org.example.service;

import org.example.model.entities.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionService {
    void createSubscription(Subscription subscription);
    Optional<Subscription> getSubscription(UUID id);
    void updateSubscription(Subscription subscription);
    void deleteSubscription(UUID id);

    List<Subscription> getAllSubscriptions();
}
