package dev.melis.travelplanapp;

import dev.melis.travelplanapp.model.User;
import dev.melis.travelplanapp.repository.UserRepository;
import dev.melis.travelplanapp.service.registration.DefaultRegistrationService;
import dev.melis.travelplanapp.service.registration.RegistrationService;
import dev.melis.travelplanapp.service.registration.RegistrationServiceRequest;
import dev.melis.travelplanapp.support.result.CreationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransplantableApplicationTests {

	private RegistrationService registrationService;
	private UserRepository userRepository;
	@Test
	@BeforeEach
	public void setUp(){
		userRepository= mock(UserRepository.class);
        registrationService= new DefaultRegistrationService(userRepository);
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
		CreationResult result= registrationService.register(request);
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
		CreationResult result= registrationService.register(request);
		assertFalse(result.isSuccess());
	}

}
