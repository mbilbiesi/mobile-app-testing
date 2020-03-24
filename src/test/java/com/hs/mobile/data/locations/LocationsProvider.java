package com.hs.mobile.data.locations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.exception.ExceptionSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationsProvider {
    private static final Logger LOG = LoggerFactory.getLogger(LocationsProvider.class);
    private static final String LOCATIONS_SOURCE = "data/locations.json";
    List<Locations> locationsList;

    String language;

    public LocationsProvider(String language) {
        this.language = language;
        try {
            String locationsFile =
                    Resources.toString(Resources.getResource(LOCATIONS_SOURCE), Charsets.UTF_8);
            locationsList =
                    new ObjectMapper().readValue(locationsFile, new TypeReference<List<Locations>>() {
                    });
        } catch (IOException e) {
            LOG.error("Unable to read locations test data file", e);
        }
    }

    private Locations getLocation(String locationType) {
        Locations location;

        location = locationsList.stream()
                .filter(loc -> loc.getLocationType().equalsIgnoreCase(locationType))
                .findFirst()
                .orElseThrow(ExceptionSupplier.failedToInitializeTest(
                        "unable to find location by " + locationType));

        return location;
    }

    public String getLocationValue(String locationType) {
        if (language.equalsIgnoreCase("en")) {
            return getLocation(locationType).getLocationEn();
        } else {
            return getLocation(locationType).getLocationAr();
        }
    }

    public List<String> getLocationCoordinates(String locationType) {
        List<String> locationCoordinates = new ArrayList<String>();

        locationCoordinates.add(getLocation(locationType).getLatitude());
        locationCoordinates.add(getLocation(locationType).getLongitude());

        return locationCoordinates;
    }
}
