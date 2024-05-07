package dev.melis.travelplanapp.service.registration;

import dev.melis.travelplanapp.model.User;
import dev.melis.travelplanapp.passwordencoder.UserPasswordEncoder;
import dev.melis.travelplanapp.repository.UserRepository;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.OperationFailureReason;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class DefaultRegistrationService implements RegistrationService{

    private final UserRepository userRepository;
    private final UserPasswordEncoder passwordEncoder;

    public DefaultRegistrationService(UserRepository userRepository, UserPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    private Pattern emailPattern = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    @Override
    public CrudResult register(RegistrationServiceRequest registrationServiceRequest) {
        Optional<User> userOptional= userRepository.findByEmail(registrationServiceRequest.getEmail());
        if(userOptional.isPresent()){
            return CrudResult.failure(OperationFailureReason.CONFLICT,"User Has Already Registered");
        }
        if(!validEmailAdress(registrationServiceRequest.getEmail())){
            return CrudResult.failure(OperationFailureReason.UNAUTHORIZED,"Invalid Email Adress");
        }
        String passwordHash=passwordEncoder.encodePassword(registrationServiceRequest.getPassword());
        var user= new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(registrationServiceRequest.getName());
        user.setSurname(registrationServiceRequest.getSurname());
        user.setEmail(registrationServiceRequest.getEmail());
        user.setPassword(passwordHash);
        user.setDate(LocalDate.now());
        userRepository.save(user);
        return CrudResult.success();
    }
    private boolean validEmailAdress(String email){
        if(email== null)
            return false;
        return emailPattern.matcher(email).find();
    }
}
