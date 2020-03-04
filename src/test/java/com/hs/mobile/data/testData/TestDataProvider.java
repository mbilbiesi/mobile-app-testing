package com.hs.mobile.data.testData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.data.user.TestUserProvider;
import com.hs.mobile.exception.ExceptionSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class TestDataProvider {
    private static final Logger LOG = LoggerFactory.getLogger(TestUserProvider.class);
    private static final String TEST_DATA_SOURCE = "data/testUsers.json";
    private List<TestData> testDataList;
    private List<Locations> locations;
    private Locations location;
    private List<Restaurants> restaurants;

    private String language;

    public TestDataProvider(String language) {
        try {
            String testDataFile = Resources.toString(Resources.getResource(TEST_DATA_SOURCE), Charsets.UTF_8);
            testDataList =
                    new ObjectMapper().readValue(testDataFile, new TypeReference<List<TestData>>() {
                    });
            this.language = language;
        } catch (IOException e) {
            LOG.error("Failed to read testData file", e);
        }
    }

    private Locations getLocation(String locationType) {
        location = locations.stream()
                .filter(location -> location.getLocationType().equals(locationType)).findFirst()
                .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find location by " + locationType));

        return location;
    }

    public String getLocationValue(String locationType) {
        if (language.equalsIgnoreCase("en")) {
            return getLocation(locationType).getLocationEn();
        } else {
            return getLocation(locationType).getLocationAr();
        }
    }
}
