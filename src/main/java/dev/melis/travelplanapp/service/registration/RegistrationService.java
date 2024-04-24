package dev.melis.travelplanapp.service.registration;

import dev.melis.travelplanapp.support.result.CreationResult;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RegistrationService {
    CreationResult register(RegistrationServiceRequest registrationServiceRequest);
}
