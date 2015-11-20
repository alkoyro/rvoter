package com.lc.rv.dao;

import com.lc.rv.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexey.Koyro
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
