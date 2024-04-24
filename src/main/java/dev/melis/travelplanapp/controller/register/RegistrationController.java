package dev.melis.travelplanapp.controller.register;

import dev.melis.travelplanapp.service.registration.RegistrationService;
import dev.melis.travelplanapp.support.resulthandler.BusinessResultHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request){
        var result= registrationService.register(request.toServiceRequest());
        if(!result.isSuccess()){
            return BusinessResultHandler.handleFailureReason(result.getReason(),result.getMessage());
        }
         return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
