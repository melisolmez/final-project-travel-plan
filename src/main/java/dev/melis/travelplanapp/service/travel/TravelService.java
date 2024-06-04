package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.config.UserSession;
import dev.melis.travelplanapp.model.Travel;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.UpdateResult;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface TravelService {

    CrudResult addTravelPlan(AddTravelRequest request, UserSession session);

    List<Travel> listAllTravelPlans(String userId);

    Travel getTravelPlan(String travelId);

    UpdateResult updateTravelInformation(String travelId, AddTravelRequest request);

    void deleteTravelPlan(String travelId);


}
