package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.config.UserSession;
import dev.melis.travelplanapp.model.Travel;
import dev.melis.travelplanapp.repository.PlaceRepository;
import dev.melis.travelplanapp.repository.TravelRepository;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.OperationFailureReason;
import dev.melis.travelplanapp.support.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultTravelService implements TravelService {

    private final TravelRepository travelRepository;
    private final PlaceRepository placeRepository;

    public DefaultTravelService(TravelRepository travelRepository, PlaceRepository placeRepository) {
        this.travelRepository = travelRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public CrudResult addTravelPlan(AddTravelRequest request, UserSession session) {
        for (String s : request.getPlaceId()){
            if (placeRepository.findById(s).isEmpty()){
                return CrudResult.failure(OperationFailureReason.PRECONDITION_FAILED,"Place not exists");
            }
        }

        var travelOptional = travelRepository.findByTitle(request.getTitle());
        if (travelOptional.isPresent()){
            return CrudResult.failure(OperationFailureReason.CONFLICT,"Title has been used");
        }

        Travel travel = new Travel()
                .setTravelId(UUID.randomUUID().toString())
                .setTitle(request.getTitle())
                .setPlaceId(request.getPlaceId())
                .setUserId(session.id());

        travelRepository.save(travel);
        return CrudResult.success();
    }

    @Override
    public List<Travel> listAllTravelPlans(String userId) {
        return travelRepository.findByUserId(userId);
    }

    @Override
    public Travel getTravelPlan(String travelId) {
        return travelRepository.findByTravelId(travelId).orElse(null);
    }

    @Override
    public UpdateResult updateTravelInformation(String travelId, AddTravelRequest request) {
        var opt = travelRepository.findByTravelId(travelId);
        if (opt.isEmpty()){
            return UpdateResult.failure(OperationFailureReason.NOT_FOUND, "Travel not found");
        }
        var updatedTravel = new Travel()
                .setTravelId(travelId)
                .setPlaceId(request.getPlaceId())
                .setTitle(request.getTitle())
                .setUserId(opt.get().getUserId());

        travelRepository.save(updatedTravel);
        return UpdateResult.success();
    }

    @Override
    public void deleteTravelPlan(String travelId) {
        travelRepository.deleteById(travelId);
    }
}
