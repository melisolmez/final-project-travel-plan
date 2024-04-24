package dev.melis.travelplanapp.service.registration;

import java.time.LocalDate;

public class RegistrationServiceRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate dateOfRegistration;

    public String getName() {
        return name;
    }

    public RegistrationServiceRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RegistrationServiceRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegistrationServiceRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationServiceRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public RegistrationServiceRequest setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

}
