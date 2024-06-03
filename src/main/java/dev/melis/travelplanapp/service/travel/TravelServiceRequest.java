package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.User;

import java.time.LocalDate;

public class TravelServiceRequest {

    private String title;
    private String city;
    private LocalDate dateOfStarting;
    private LocalDate dateOfFinishing;

    private String description;
    private String userId;

    public String getTitle() {
        return title;
    }

    public TravelServiceRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCity() {
        return city;
    }

    public TravelServiceRequest setCity(String city) {
        this.city = city;
        return this;
    }

    public LocalDate getDateOfStarting() {
        return dateOfStarting;
    }

    public TravelServiceRequest setDateOfStarting(LocalDate dateOfStarting) {
        this.dateOfStarting = dateOfStarting;
        return this;
    }

    public LocalDate getDateOfFinishing() {
        return dateOfFinishing;
    }

    public TravelServiceRequest setDateOfFinishing(LocalDate dateOfFinishing) {
        this.dateOfFinishing = dateOfFinishing;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public TravelServiceRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TravelServiceRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }


}
