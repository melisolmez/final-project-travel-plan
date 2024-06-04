package dev.melis.travelplanapp.controller.travel;

import dev.melis.travelplanapp.model.City;
import dev.melis.travelplanapp.service.travel.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/city/{name}")
    public List<City> getCity(@PathVariable String name){
        return cityService.getCity(name);
    }
    @PostMapping("/city")
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }

}
