package dev.melis.travelplanapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection ="travels")
public class Travel {
    @Id
    private String travelId;
    private String title;
    private String city;
    private LocalDate dateOfStarting;
    private LocalDate dateOfFinishing;
    private boolean isTravelCompleted;

    private String description;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return travelId;
    }

    public void setId(String id) {
        this.travelId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfStarting() {
        return dateOfStarting;
    }

    public void setDateOfStarting(LocalDate dateOfStarting) {
        this.dateOfStarting = dateOfStarting;
    }

    public LocalDate getDateOfFinishing() {
        return dateOfFinishing;
    }

    public void setDateOfFinishing(LocalDate dateOfFinishing) {
        this.dateOfFinishing = dateOfFinishing;
    }

    public boolean isTravelCompleted() {
        return isTravelCompleted;
    }

    public void setTravelCompleted(boolean travelCompleted) {
        isTravelCompleted = travelCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
