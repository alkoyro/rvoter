package com.lc.rv.service.impl;

import com.lc.rv.dao.RestaurantRepository;
import com.lc.rv.entity.Restaurant;
import com.lc.rv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Alexey.Koyro
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Page<Restaurant> loadAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurant.getId() != null) {
            throw new IllegalArgumentException("Not allowed to add new restraurant with existing id");
        }
        return restaurantRepository.save(restaurant);
    }
}
