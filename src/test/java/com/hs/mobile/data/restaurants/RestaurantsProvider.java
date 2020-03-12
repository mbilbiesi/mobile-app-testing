package com.hs.mobile.data.restaurants;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.exception.ExceptionSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class RestaurantsProvider {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantsProvider.class);
    private static final String RESTAURANTS_SOURCE = "data/restaurants.json";
    List<Restaurants> restaurantsList;

    String language;

    public RestaurantsProvider(String language) {
        this.language = language;
        try {
            String restaurantsFile =
                    Resources.toString(Resources.getResource(RESTAURANTS_SOURCE), Charsets.UTF_8);
            restaurantsList =
                    new ObjectMapper().readValue(restaurantsFile, new TypeReference<List<Restaurants>>() {
                    });
        } catch (IOException e) {
            LOG.error("Unable to read restaurants test data file", e);
        }
    }

    private Restaurants getRestaurant(String restaurantType) {
        return restaurantsList.stream()
                .filter(rest -> rest.getRestaurantType().equalsIgnoreCase(restaurantType))
                .findFirst()
                .orElseThrow(
                        ExceptionSupplier.failedToInitializeTest("Unable to find restaurant by it's type"));
    }

    public String getRestaurantName(String restaurantType) {
        if (language.equalsIgnoreCase("en")) {
            return getRestaurant(restaurantType).getEn();
        } else {
            return getRestaurant(restaurantType).getAr();
        }
    }
}
