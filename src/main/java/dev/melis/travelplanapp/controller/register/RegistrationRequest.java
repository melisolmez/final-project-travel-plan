package dev.melis.travelplanapp.controller.register;

import dev.melis.travelplanapp.service.registration.RegistrationServiceRequest;

public record RegistrationRequest(
        String name,
        String surname,
        String email,
        String password

) {
    RegistrationServiceRequest toServiceRequest(){
        return new RegistrationServiceRequest()
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPassword(password);
    }
}
