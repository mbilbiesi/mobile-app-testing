package com.hungerstation.test;

import com.hungerstation.screens.Alerts;
import com.hungerstation.screens.Homepage;
import com.hungerstation.screens.Locations;
import com.hungerstation.screens.Restaurant;
import com.hungerstation.screens.RestaurantsList;
import com.hungerstation.util.RunCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Demo extends RunCapabilities {

   /* @BeforeTest
    public void killAllNodes() throws IOException {//Kill all the nodes, then it starts execution freshly
        Runtime.getRuntime().exec("taskklill /F /IM node.exe");
    }*/

    @Test
    public void fullScenario() throws IOException, InterruptedException {
        service = startServer();
        AndroidDriver<MobileElement> driver = capabilities("hsApp");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Alerts alerts;
        Homepage hp;
        Locations locations;
        RestaurantsList restaurantsList;
        Restaurant restaurant;

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        //alerts = new Alerts(driver);
        hp = new Homepage(driver);
        locations = new Locations(driver);
        restaurantsList = new RestaurantsList(driver);
        restaurant = new Restaurant(driver);

        driver.switchTo().alert().accept();
        //alerts.btnLocationAlert.get(0).click();
        //await().atMost(10, TimeUnit.SECONDS).until(() -> locationAlert.size()>0);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(tapOptions().withElement(element(hp.btnSearchForRestaurants))).perform();

        touchAction.tap(tapOptions().withElement(element(locations.btnSearch))).perform();

        locations.txtSearch.sendKeys("riyadh");

        touchAction.tap(tapOptions().withElement(element(locations.itemAreas.get(2)))).perform();

        touchAction.tap(tapOptions().withElement(element(locations.btnSelectAddress))).perform();

        locations.txtAddressDescription.sendKeys("test");

        touchAction.tap(tapOptions().withElement(element(locations.btnSelectAddress))).perform();

        touchAction.tap(tapOptions().withElement(element(restaurantsList.eleRestaurant.get(0)))).perform();

        touchAction.tap(tapOptions().withElement(element(restaurant.eleMenuItems.get(0)))).perform();

        touchAction.tap(tapOptions().withElement(element(restaurant.btnAddMenuItem))).perform();

        touchAction.tap(tapOptions().withElement(element(restaurant.btnCart))).perform();

        service.stop();
    }
}
