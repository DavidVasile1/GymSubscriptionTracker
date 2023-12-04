package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entities.Subscription;
import org.example.repository.SubscriptionRepository;
import org.example.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    public final SubscriptionRepository subscriptionRepository;
    @Override
    public void createSubscription(Subscription subscription) {
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.parse(subscription.getStartDate().toString()).plusDays(30));
        subscriptionRepository.save(subscription);
    }

    @Override
    public Optional<Subscription> getSubscription(UUID id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);

    }

    @Override
    public void deleteSubscription(UUID id) {
        subscriptionRepository.deleteById(id);

    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();

    }
}
