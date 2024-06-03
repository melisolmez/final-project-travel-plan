package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.Travel;
import dev.melis.travelplanapp.repository.TravelRepository;
import dev.melis.travelplanapp.support.result.CrudResult;
import dev.melis.travelplanapp.support.result.OperationFailureReason;
import dev.melis.travelplanapp.support.result.UpdateResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTravelService implements TravelService {

    private final TravelRepository travelRepository;

    public DefaultTravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public CrudResult addTravelPlan(TravelServiceRequest request) {
        var plan= new Travel();
                plan.setTitle(request.getTitle());
                plan.setCity(request.getCity());
                plan.setDescription(request.getDescription());
                plan.setDateOfStarting(request.getDateOfStarting());
                plan.setDateOfFinishing(request.getDateOfFinishing());
                plan.setUserId(request.getUserId());
                travelRepository.save(plan);
                return CrudResult.success();

    }

    @Override
    public List<Travel> listAllTravelPlans(String userId) {
        return travelRepository.findByUserId(userId);
    }

    @Override
    public Travel getTravelPlan(String travelId) {
        Optional<Travel> travelOptional= travelRepository.findByTravelId(travelId);
        return travelOptional.orElse(null);
    }
    @Override
    public UpdateResult updateTravelInformation(String travelId, TravelServiceRequest request) {
        Optional<Travel> travelOptional= travelRepository.findByTravelId(travelId);
        if(travelOptional.isPresent()){
            var travelFromDb= travelOptional.get();
            replaceTravelInformation(request,travelFromDb);
            travelRepository.save(travelFromDb);
            return UpdateResult.success();
        }
        return UpdateResult.failure(OperationFailureReason.NOT_FOUND,"Travel plan not found");
    }

    @Override
    public void deleteTravelPlan(String travelId) {
         travelRepository.deleteById(travelId);
    }

    private void replaceTravelInformation(TravelServiceRequest request, Travel travelFromDb) {
        if(!ObjectUtils.isEmpty(request.getTitle())){
            travelFromDb.setTitle(request.getTitle());
        }
        if(!ObjectUtils.isEmpty(request.getCity())){
            travelFromDb.setCity(request.getCity());
        }
        if(!ObjectUtils.isEmpty(request.getDescription())){
            travelFromDb.setDescription(request.getDescription());
        }
        if(!ObjectUtils.isEmpty(request.getDateOfStarting())){
            travelFromDb.setDateOfStarting(request.getDateOfStarting());
        }
        if(!ObjectUtils.isEmpty(request.getDateOfFinishing())) {
            travelFromDb.setDateOfFinishing(request.getDateOfFinishing());
        }
    }

}
