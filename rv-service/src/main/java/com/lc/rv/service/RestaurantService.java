package com.lc.rv.service;

import com.lc.rv.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Alexey.Koyro
 */
public interface RestaurantService {
    Page<Restaurant> loadAll(Pageable pageable);

    @PreAuthorize("hasRole('ADMIN')")
    Restaurant addRestaurant(Restaurant restaurant);
}
