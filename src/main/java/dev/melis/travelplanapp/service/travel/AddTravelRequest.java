package dev.melis.travelplanapp.service.travel;

import java.util.List;

public class AddTravelRequest {
    private String title;
    private List<String> placeId;

    public String getTitle() {
        return title;
    }

    public AddTravelRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<String> getPlaceId() {
        return placeId;
    }

    public AddTravelRequest setPlaceId(List<String> placeId) {
        this.placeId = placeId;
        return this;
    }
}
