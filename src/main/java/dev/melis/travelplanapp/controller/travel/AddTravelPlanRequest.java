package dev.melis.travelplanapp.controller.travel;

import dev.melis.travelplanapp.service.travel.AddTravelRequest;

import java.util.List;

public record AddTravelPlanRequest(
        String title,
        List<String> placeId
) {
    AddTravelRequest toServiceRequest(){
        return new AddTravelRequest()
                .setPlaceId(placeId)
                .setTitle(title);
    }
}
