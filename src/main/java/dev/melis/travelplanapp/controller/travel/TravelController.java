package dev.melis.travelplanapp.controller.travel;

import dev.melis.travelplanapp.config.UserSession;
import dev.melis.travelplanapp.service.travel.TravelService;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.UpdateResult;
import dev.melis.travelplanapp.support.resulthandler.BusinessResultHandler;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping("/travels")
    ResponseEntity<?> addTravelPlan(@RequestBody AddTravelPlanRequest request, UserSession session){
        CrudResult result = travelService.addTravelPlan(request.toServiceRequest(), session);
        if (result.isSuccess()){
            return ResponseEntity.ok().build();
        }else{
            return BusinessResultHandler.handleFailureReason(result.getReason(),result.getMessage());
        }
    }

    @PostMapping("/travels/{travelId}")
    ResponseEntity<?> updateTravelPlan(@RequestBody AddTravelPlanRequest request, String travelId){
        UpdateResult result = travelService.updateTravelInformation(travelId,request.toServiceRequest());
        if (result.isSuccess()){
            return ResponseEntity.ok().build();
        }else{
            return BusinessResultHandler.handleFailureReason(result.getReason(),result.getMessage());
        }
    }

    @GetMapping("/travels")
    ResponseEntity<?> getTravelPlans(UserSession session){
        return ResponseEntity.ok(travelService.listAllTravelPlans(session.id()));
    }

    @GetMapping("/travels/{travelId}")
    ResponseEntity<?> getTravelPlanById(@PathVariable String travelId){
        return ResponseEntity.ok(travelService.getTravelPlan(travelId));
    }

    @DeleteMapping("/travels/{travelId}")
    ResponseEntity<?> deleteTravel(@PathVariable String travelId){
        travelService.deleteTravelPlan(travelId);
        return ResponseEntity.status(204).build();
    }
}
