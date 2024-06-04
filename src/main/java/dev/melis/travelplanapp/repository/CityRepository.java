package dev.melis.travelplanapp.repository;

import dev.melis.travelplanapp.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends MongoRepository<City,String> {
    List<City> findBySehir(String name);
    Optional<City> findById(String id);
}
