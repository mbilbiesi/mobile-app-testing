package com.hs.mobile.data.locations;

import static com.hs.mobile.exception.ExceptionSupplier.failedToInitializeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.locations.model.Locations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationsProvider {

  private static final String LOCATIONS_SOURCE = "data/locations.json";
  @NonNull
  private final TestSettings settings;
  private List<Locations> locationsList;

  public LocationsProvider(TestSettings settings) {
    this.settings = settings;
    try {
      String locationsFile =
          Resources.toString(Resources.getResource(LOCATIONS_SOURCE), Charsets.UTF_8);
      locationsList =
          new ObjectMapper().readValue(locationsFile, new TypeReference<List<Locations>>() {
          });
    } catch (IOException e) {
      log.error("Unable to read locations test data file", e);
    }
  }

  private Locations getLocation(String locationType) {
    return locationsList.stream()
        .filter(location -> location.getLocationType().equalsIgnoreCase(locationType))
        .findFirst()
        .orElseThrow(failedToInitializeTest("unable to find location by " + locationType));
  }

  public String getLocationValue(String locationType) {
    if (settings.getTestLanguage().equalsIgnoreCase("en")) {
      return getLocation(locationType).getLocationEn();
    } else {
      return getLocation(locationType).getLocationAr();
    }
  }

  public List<String> getLocationCoordinates(String locationType) {
    List<String> locationCoordinates = new ArrayList<>();

    locationCoordinates.add(getLocation(locationType).getLatitude());
    locationCoordinates.add(getLocation(locationType).getLongitude());

    return locationCoordinates;
  }
}
