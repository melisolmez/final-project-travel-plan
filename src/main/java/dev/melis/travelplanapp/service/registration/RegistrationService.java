package dev.melis.travelplanapp.service.registration;

import org.springframework.validation.annotation.Validated;

@Validated
public interface RegistrationService {
    boolean register(RegistrationServiceRequest registrationServiceRequest);
}
