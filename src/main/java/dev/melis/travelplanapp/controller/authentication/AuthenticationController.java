package dev.melis.travelplanapp.controller.authentication;

import dev.melis.travelplanapp.repository.UserRepository;
import dev.melis.travelplanapp.service.authentication.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@Validated
public class AuthenticationController {

   private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;

    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthenticationRequest request){
        var result= authenticationService.authenticate(request.toServiceRequest());
        if(result.isSuccess()){
            return ResponseEntity.ok(Map.of("token",result.getMessage()));
        }
        return new ResponseEntity<>(Map.of("message","Wrong credentials"), HttpStatus.UNAUTHORIZED);
    }

}
