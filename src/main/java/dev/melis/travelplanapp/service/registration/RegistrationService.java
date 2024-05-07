package dev.melis.travelplanapp.service.registration;

import dev.melis.travelplanapp.support.result.CrudResult;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RegistrationService {
    CrudResult register(RegistrationServiceRequest registrationServiceRequest);
}
