package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.Place;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.List;

@Validated
public interface PlaceService {

    List<?> getPlacesByCityName(String name);

    Place getPlaceById(String id);

    void addPlace(SavePlaceRequest request) throws IOException;

    void deleteById(String placeId);
}
