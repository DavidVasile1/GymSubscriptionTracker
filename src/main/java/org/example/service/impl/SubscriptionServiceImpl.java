package org.example.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.entities.Classes;
import org.example.model.entities.Subscription;
import org.example.repository.ClassesRepository;
import org.example.repository.SubscriptionRepository;
import org.example.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final EntityManager entityManager;
    private final ClassesRepository classesRepository;

    @Override
    @Transactional
    public void createSubscription(Subscription subscription) {
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(subscription.getStartDate().plusDays(30));
        subscriptionRepository.save(subscription);
        entityManager.flush();
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
