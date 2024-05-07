package dev.melis.travelplanapp.passwordencoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserPasswordEncoder {

    String encodePassword(String password);
    PasswordEncoder getEncoder();
    boolean matches(String password, String passwordHash);
}
