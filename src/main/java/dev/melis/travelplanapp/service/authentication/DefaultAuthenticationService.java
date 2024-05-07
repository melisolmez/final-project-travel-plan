package dev.melis.travelplanapp.service.authentication;

import dev.melis.travelplanapp.passwordencoder.UserPasswordEncoder;
import dev.melis.travelplanapp.repository.UserRepository;
import dev.melis.travelplanapp.service.jwt.JwtService;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.OperationFailureReason;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthenticationService implements AuthenticationService{

    private final UserRepository userRepository;
    private final UserPasswordEncoder userPasswordEncoder;

    private final JwtService jwtService;
    public DefaultAuthenticationService(UserRepository userRepository, UserPasswordEncoder userPasswordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
        this.jwtService = jwtService;
    }
    @Override
    public CrudResult authenticate(AuthenticationServiceRequest request) {
        var userOptional= userRepository.findByEmail(request.getEmail());
        if(userOptional.isEmpty()){
            return CrudResult.failure(OperationFailureReason.NOT_FOUND,"User not found");
        }

        var userFromDb= userOptional.get();
        if(!userPasswordEncoder.matches(request.getPassword(), userFromDb.getPassword())){
            return CrudResult.failure(OperationFailureReason.UNAUTHORIZED,"Invalid credentials");
        }

        var jwtToken= jwtService.generateToken(userFromDb);
        return CrudResult.success(jwtToken);
    }
}
