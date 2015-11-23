package com.lc.rv.rest.controller;

import com.lc.rv.entity.Restaurant;
import com.lc.rv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alexey.Koyro
 */
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpEntity<PagedResources<Restaurant>> getRestaurants(Pageable pageable, PagedResourcesAssembler pagedResourcesAssembler) {

        Page<Restaurant> restaurantPage = restaurantService.loadAll(pageable);

        HttpEntity<PagedResources<Restaurant>> restaurantPageHttpEntity =
                new ResponseEntity<PagedResources<Restaurant>>(pagedResourcesAssembler.toResource(restaurantPage), HttpStatus.OK);

        return restaurantPageHttpEntity;
    }


}
