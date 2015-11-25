package com.lc.rv.rest.resource.assembler;

import com.lc.rv.entity.Restaurant;
import com.lc.rv.rest.controller.RestaurantController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * @author Alexey.Koyro
 */
@Service
public class RestaurantResourceAssembler extends ResourceAssemblerSupport<Restaurant, Resource> {


    public RestaurantResourceAssembler() {
        super(RestaurantController.class, Resource.class);
    }

    @Override
    public Resource<Restaurant> toResource(Restaurant restaurant) {
        return new Resource<Restaurant>(restaurant, ControllerLinkBuilder.linkTo(RestaurantController.class).
                slash(restaurant.getId()).withSelfRel());
    }

}
