package com.lc.rv.rest.controller;

import com.lc.rv.entity.Restaurant;
import com.lc.rv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alexey.Koyro
 */
@RestController
public class RestaurantController {

    private static final String DEFAULT_PAGE_NUMBER_VALUE = "0";
    private static final Integer DEFAULT_PAGE_SIZE = 30;

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Page<Restaurant>> getRestaurants(
            @RequestParam(required = false, defaultValue = DEFAULT_PAGE_NUMBER_VALUE) Integer page) {
        PageRequest pageRequest = new PageRequest(page, DEFAULT_PAGE_SIZE);
        Page<Restaurant> restaurantPage = restaurantService.loadAll(pageRequest);

        HttpEntity<Page<Restaurant>> restaurantPageHttpEntity = new ResponseEntity<Page<Restaurant>>(restaurantPage, HttpStatus.OK);
        return restaurantPageHttpEntity;
    }
}
