package com.lc.rv.service;

import com.lc.rv.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Alexey.Koyro
 */
public interface RestaurantService {
    Page<Restaurant> loadAll(Pageable pageable);
}
