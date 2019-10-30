package com.hungerstation.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class HungerstationBasics{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        AndroidDriver<MobileElement> driver = capabilities("android", "hs");
//        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//
//        List<MobileElement> locationAlert = driver.findElementsById("com.android.packageinstaller:" +
//                "id/permission_allow_button");
//        //await().atMost(10, TimeUnit.SECONDS).until(() -> locationAlert.size()>0);
//
//        WebElement BtnSearchForRestaurant = driver.findElementById("com.hungerstation.android.web.debug:id/BtnRestaurants");
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.tap(tapOptions().withElement(element(BtnSearchForRestaurant))).perform();
//
//        WebElement searchIcon = driver.findElementById("com.hungerstation.android.web.debug:id/action_search");
//        touchAction.tap(tapOptions().withElement(element(searchIcon))).perform();
//
//        WebElement txtSearch = driver.findElementById("com.hungerstation.android.web.debug:id/places_autocomplete_edit_text");
//
//        txtSearch.sendKeys("riyadh");
//
//        WebElement place = driver.findElementsByClassName("android.widget.RelativeLayout").get(0);
//        touchAction.tap(tapOptions().withElement(element(place))).perform();
//
//        WebElement BtnselectAddress = driver.findElementById("com.hungerstation.android.web.debug:id/BtnAddAddress");
//
//        touchAction.tap(tapOptions().withElement(element(BtnselectAddress))).perform();
//
//        WebElement txtLocationDesc = driver.findElementById("com.hungerstation.android.web.debug:id/editDescription");
//        txtLocationDesc.sendKeys("test");
//
//        touchAction.tap(tapOptions().withElement(element(BtnselectAddress))).perform();
//
//        WebElement restaurant = driver.findElementsByClassName("android.view.View").get(1);
//        touchAction.tap(tapOptions().withElement(element(restaurant))).perform();
//
//        List<MobileElement> menuItems = driver.findElementsByClassName("android.view.ViewGroup");
//        touchAction.tap(tapOptions().withElement(element(menuItems.get(0)))).perform();
//
//        WebElement BtnAdd = driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout");
//        touchAction.tap(tapOptions().withElement(element(BtnAdd))).perform();
//
//        touchAction.tap(tapOptions().withElement(element(menuItems.get(1)))).perform();
//        touchAction.tap(tapOptions().withElement(element(BtnAdd))).perform();

    }


}
