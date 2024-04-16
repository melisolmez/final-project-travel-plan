package dev.melis.travelplanapp.service.registration;

import dev.melis.travelplanapp.model.User;
import dev.melis.travelplanapp.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

public class DefaultRegistrationService implements RegistrationService{

    private final UserRepository userRepository;

    public DefaultRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(RegistrationServiceRequest registrationServiceRequest) {
        Optional<User> userOptional= userRepository.findByEmail(registrationServiceRequest.getEmail());
        if(userOptional.isPresent()){
            return false;
        }
        var user= new User();
        user.setName(registrationServiceRequest.getName());
        user.setSurname(registrationServiceRequest.getSurname());
        user.setEmail(registrationServiceRequest.getEmail());
        user.setPassword(registrationServiceRequest.getPassword());
        user.setDate(LocalDate.now());
        userRepository.save(user);
        return true;
    }
}
