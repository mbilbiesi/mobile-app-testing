package com.hs.mobile.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Epic("Smoke Tests")
@Feature("Restaurants List Tests")
@Execution(ExecutionMode.CONCURRENT)
class RestaurantsListTests extends BaseTest {

    @Test
    @Issue("HSAP-180")
    @Story("Check Restaurants List Screen Layout")
    @Description("Make sure that all Restaurant List objects are displayed correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void checkRestaurantsListLayout(TestInfo testInfo){
        homeScreen.clickFindRestaurantsButton();
        /*
        Location steps
         */
        restaurantsListScreen.verifyRestaurantsListLayout();
    }

}
