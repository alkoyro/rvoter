package com.lc.rv.rest.controller;

import com.lc.rv.entity.Restaurant;
import com.lc.rv.rest.resource.assembler.RestaurantResourceAssembler;
import com.lc.rv.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alexey.Koyro
 */
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantResourceAssembler restaurantResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpEntity<PagedResources<Restaurant>> getRestaurants(Pageable pageable,
                                                                 PagedResourcesAssembler pagedResourcesAssembler) {
        Page<Restaurant> restaurantPage = restaurantService.loadAll(pageable);

        return new ResponseEntity<PagedResources<Restaurant>>(pagedResourcesAssembler.
                toResource(restaurantPage, restaurantResourceAssembler), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public HttpEntity<Resource<Restaurant>> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant);
        Resource<Restaurant> restaurantResource = restaurantResourceAssembler.toResource(createdRestaurant);

        return new ResponseEntity<Resource<Restaurant>>(restaurantResource, HttpStatus.CREATED);
    }


}
