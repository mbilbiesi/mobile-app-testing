package com.hs.mobile.data.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.exception.ExceptionSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class TestUserProvider {
    private static final Logger LOG = LoggerFactory.getLogger(TestUserProvider.class);
    private static final String TEST_USERS_DATA_SOURCE = "data/testUsers.json";
    private List<TestUser> testUserList;

    public TestUserProvider() {

        try {
            String testUsersFile =
                    Resources.toString(Resources.getResource(TEST_USERS_DATA_SOURCE), Charsets.UTF_8);
            testUserList =
                    new ObjectMapper().readValue(testUsersFile, new TypeReference<List<TestUser>>() {
                    });
        } catch (IOException e) {
            LOG.error("Failed to read Genre mapping file", e);
        }
    }

    public TestUser getUser(String userId) {
        return testUserList.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(
                        ExceptionSupplier.failedToInitializeTest("failed to find User with id: " + userId));
    }
}
