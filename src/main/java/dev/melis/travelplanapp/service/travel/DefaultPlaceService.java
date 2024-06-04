package dev.melis.travelplanapp.service.travel;

import dev.melis.travelplanapp.model.Place;
import dev.melis.travelplanapp.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultPlaceService implements PlaceService {
    private final PlaceRepository placeRepository;

    public DefaultPlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<?> getPlacesByCityName(String name) {
        return placeRepository.findBySehir(name);
    }

    @Override
    public Place getPlaceById(String id) {
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public void addPlace(SavePlaceRequest request) throws IOException {
        Place place = new Place()
                .setId(UUID.randomUUID().toString())
                .setSehir(request.getSehir())
                .setIsim(request.getIsim())
                .setAciklama(request.getAciklama())
                .setResim(request.getPlaceImage().getBytes());

        placeRepository.save(place);
    }

    @Override
    public void deleteById(String placeId) {
        placeRepository.deleteById(placeId);
    }
}
