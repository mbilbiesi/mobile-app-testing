package com.hs.mobile.tests;

import com.hs.mobile.tests.base.BaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

//this class is a temp file to test parallelism

@Feature("Verify Test Lab feature")
@Story("test connectivity with test Lab")
public class TestParallel extends BaseSteps {

    @Test(description = "just checking test lab")
    void verifyTestLab() throws InterruptedException {
        // Given
        Thread.sleep(60000);
    }
}
