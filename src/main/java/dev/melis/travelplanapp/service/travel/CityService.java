package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.City;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface CityService {

    List<City> getCity(String name);

    void addCity(City city);


}
