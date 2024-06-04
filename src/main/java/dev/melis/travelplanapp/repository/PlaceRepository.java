package dev.melis.travelplanapp.repository;

import dev.melis.travelplanapp.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends MongoRepository<Place,String> {

    Optional<Place> findById(String id);

    List<Place> findBySehir(String sehir);

}
