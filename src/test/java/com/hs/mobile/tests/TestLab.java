package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Verify Test Lab feature")
@Story("test connectivity with test Lab")
@Listeners(TestListener.class)
public class TestLab extends BaseStepsInitiator {

    @Test(description = "just checking test lab")
    void verifyTestLab() {
        System.out.println("Thread>>>" + Thread.currentThread().getId());
        // Given
        driver.findElementById("xx").click();


    }
}
