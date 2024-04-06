package com.example.CourseRegistrationSystem.repository;

import com.example.CourseRegistrationSystem.data.Registration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationRepository {

    private final List<Registration> registrations;

    public RegistrationRepository(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Registration add(Registration registration) {
        registrations.add(registration);
        return registration;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }
}
