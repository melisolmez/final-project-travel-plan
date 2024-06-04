package dev.melis.travelplanapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection ="travels")
public class Travel {
    @Id
    private String travelId;

    @Indexed
    private String title;

    private List<String> placeId;

    @Indexed
    private String userId;

    public String getTravelId() {
        return travelId;
    }

    public Travel setTravelId(String travelId) {
        this.travelId = travelId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Travel setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<String> getPlaceId() {
        return placeId;
    }

    public Travel setPlaceId(List<String> placeId) {
        this.placeId = placeId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Travel setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
