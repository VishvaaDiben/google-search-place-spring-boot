package com.googleplaces.favouriteplaces.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.googleplaces.favouriteplaces.service.FavoritePlaceService;
import com.googleplaces.favouriteplaces.model.FavoritePlace;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/favorite-places")
public class FavoritePlaceController {
    private final FavoritePlaceService service;
    private static final Logger logger = LoggerFactory.getLogger(FavoritePlaceController.class);

    public FavoritePlaceController(FavoritePlaceService service) {
        this.service = service;
    }

    @PostMapping
    public FavoritePlace saveFavoritePlace(@RequestBody FavoritePlace place) {
        logger.info("Received request to save favorite place: {}", place);
        return service.saveFavoritePlace(place);
    }

    @GetMapping
    public Page<FavoritePlace> getFavoritePlaces(@RequestParam(defaultValue = "0") int page, 
                                                 @RequestParam(defaultValue = "10") int size) {
        logger.info("Received request to fetch favorite places - Page: {}, Size: {}", page, size);
        return service.getAllFavoritePlaces(page, size);
    }

    @GetMapping("/fetch-google-place")
    public String fetchGooglePlace(@RequestParam String placeId) {
        logger.info("Received request to fetch place details from Google API for placeId: {}", placeId);
        return service.fetchPlaceDetailsFromGoogle(placeId);
    }
}

