package dev.melis.travelplanapp.controller.authentication;

import dev.melis.travelplanapp.service.authentication.AuthenticationServiceRequest;

public record AuthenticationRequest(
        String email,
        String password
) {
    AuthenticationServiceRequest toServiceRequest(){
        return  new AuthenticationServiceRequest()
                .setEmail(email)
                .setPassword(password);
    }
}
