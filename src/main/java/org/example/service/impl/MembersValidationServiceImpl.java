package org.example.service.impl;

import org.example.service.MembersValidationService;
import org.springframework.stereotype.Service;

@Service
public class MembersValidationServiceImpl implements MembersValidationService {

    @Override
    public void firstAndLastNameValidation(String firstName, String lastName) {
        if (!isValidName(firstName)) {
            throw new RuntimeException("Invalid first name");
        }

        if (!isValidName(lastName)) {
            throw new RuntimeException("Invalid last name");
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[A-Z][a-z]*$");
    }
}