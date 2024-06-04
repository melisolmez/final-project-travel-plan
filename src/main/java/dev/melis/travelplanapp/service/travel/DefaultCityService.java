package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.City;
import dev.melis.travelplanapp.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultCityService implements CityService{
    private final CityRepository cityRepository;

    public DefaultCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getCity(String name) {
        List<City> list= cityRepository.findBySehir(name);
        return list;
    }
    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }
}
