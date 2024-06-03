package dev.melis.travelplanapp.repository;

import dev.melis.travelplanapp.model.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends MongoRepository<Travel,String> {
    List<Travel> findByUserId(String userId);
    Optional<Travel> findByTravelId(String travelId);
}
