package dev.melis.travelplanapp;

import dev.melis.travelplanapp.model.User;
import dev.melis.travelplanapp.passwordencoder.UserPasswordEncoder;
import dev.melis.travelplanapp.passwordencoder.UserPasswordEncoderAdapter;
import dev.melis.travelplanapp.repository.UserRepository;
import dev.melis.travelplanapp.service.authentication.AuthenticationService;
import dev.melis.travelplanapp.service.authentication.AuthenticationServiceRequest;
import dev.melis.travelplanapp.service.authentication.DefaultAuthenticationService;
import dev.melis.travelplanapp.service.jwt.JwtService;
import dev.melis.travelplanapp.service.registration.DefaultRegistrationService;
import dev.melis.travelplanapp.service.registration.RegistrationService;
import dev.melis.travelplanapp.service.registration.RegistrationServiceRequest;
import dev.melis.travelplanapp.support.result.CrudResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransplantableApplicationTests {

	@Mock
	private RegistrationService registrationService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserPasswordEncoder userPasswordEncoder;
	private User testuser;
	@InjectMocks
	private DefaultAuthenticationService authenticationService;
	@Mock
	private JwtService jwtService;
	@Test
	@BeforeEach
	public void setUp(){
		userRepository= mock(UserRepository.class);
        registrationService= new DefaultRegistrationService(userRepository,userPasswordEncoder);
		jwtService= new JwtService();
		authenticationService= new DefaultAuthenticationService(userRepository,userPasswordEncoder,jwtService);
		userPasswordEncoder= new UserPasswordEncoderAdapter();

		testuser= new User();
		testuser.setEmail("melisolmez@gmail.com");
		testuser.setPassword(userPasswordEncoder.encodePassword("1234"));
	}

	@Test
	void testRegisterUserWhenUserDoesNotExist(){
		RegistrationServiceRequest request= new RegistrationServiceRequest();
		request.setName("Melis");
		request.setSurname("Olmez");
		request.setEmail("olmezmelis@gmail.com");
		request.setPassword("1234");
		request.setDateOfRegistration(LocalDate.now());

		when(userRepository.findByEmail("olmezmelis@gmail.com")).thenReturn(Optional.empty());
		CrudResult result= registrationService.register(request);
		assertTrue(result.isSuccess());
	}

	@Test
	void testRegisterUserWhenUserExist(){
		RegistrationServiceRequest request= new RegistrationServiceRequest();
		request.setName("Melis");
		request.setSurname("Olmez");
		request.setEmail("olmezmelis@gmail.com");
		request.setPassword("1234");
		request.setDateOfRegistration(LocalDate.now());

		when(userRepository.findByEmail("olmezmelis@gmail.com")).thenReturn(Optional.of(new User()));
		CrudResult result= registrationService.register(request);
		assertFalse(result.isSuccess());
	}

	@Test
	void testLogin() {
		AuthenticationServiceRequest request = new AuthenticationServiceRequest();
		request.setEmail("melisolmez@gmail.com");
		request.setPassword("1234");
		when(userRepository.findByEmail("melisolmez@gmail.com")).thenReturn(Optional.of(testuser));
		when(userPasswordEncoder.matches("1234", testuser.getPassword())).thenReturn(true);
		var response = authenticationService.authenticate(request);

		assertFalse(response.isSuccess());
	}

}
