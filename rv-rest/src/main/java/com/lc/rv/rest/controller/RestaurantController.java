package com.lc.rv.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexey.Koyro
 */
@RestController
public class RestaurantController {

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public String getRestaurants() {
        return "{restaurants: {id:1,name:someName}}";
    }
}
