package com.googleplaces.favouriteplaces.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.googleplaces.favouriteplaces.repository.FavoritePlaceRepository;
import com.googleplaces.favouriteplaces.model.FavoritePlace;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class FavoritePlaceService {
    private final FavoritePlaceRepository repository;
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(FavoritePlaceService.class);

    @Value("${google.places.api.key}")
    private String googleApiKey;

    public FavoritePlaceService(FavoritePlaceRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public FavoritePlace saveFavoritePlace(FavoritePlace place) {
        logger.info("Saving favorite place: {}", place);
        return repository.save(place);
    }

    public Page<FavoritePlace> getAllFavoritePlaces(int page, int size) {
        logger.info("Fetching favorite places - Page: {}, Size: {}", page, size);
        return repository.findAll(PageRequest.of(page, size));
    }

    public String fetchPlaceDetailsFromGoogle(String placeId) {
        String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&key=" + googleApiKey;
        logger.info("Calling Google Places API: {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}

