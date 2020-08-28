package com.hs.mobile.tests;

import com.hs.mobile.tests.base.BaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Verify Test Lab feature")
@Story("test connectivity with test Lab")
public class TestLab extends BaseSteps {

    @Test(description = "just checking test lab")
    void verifyTestLab() {
        System.out.println("Thread>>>" + Thread.currentThread().getId());
        // Given
        driver.findElementById("xx").click();


    }
}
