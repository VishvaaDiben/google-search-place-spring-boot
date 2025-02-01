package com.googleplaces.favouriteplaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.googleplaces.favouriteplaces.model.FavoritePlace;

public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {
    Page<FavoritePlace> findAll(Pageable pageable);
}
