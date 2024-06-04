package dev.melis.travelplanapp.controller.travel;

import dev.melis.travelplanapp.service.travel.PlaceService;
import dev.melis.travelplanapp.service.travel.SavePlaceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


import java.util.List;

@RestController
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }


    @GetMapping("/places/{cityName}")
    public List<?> getPlacesByCityName(@PathVariable String cityName){
        return placeService.getPlacesByCityName(cityName);
    }

    @PostMapping(value = "/places", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> savePlace(@ModelAttribute SavePlaceRequest request){
        try{
            placeService.addPlace(request);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Place saved.");
    }

    @DeleteMapping("/places/{placeId}")
    ResponseEntity<?> deletePlace(@PathVariable String placeId){
        placeService.deleteById(placeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
