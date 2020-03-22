package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class HomeScreen extends AbstractScreen {

  @iOSXCUITFindBy(id = "home.location_button")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
//  @AssertElementVisibility
  private MobileElement useMyCurrentLocationText;

  //    @iOSXCUITFindBy(id = "TBD")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
//  @AssertElementVisibility
  private MobileElement useMyCurrentLocationImage;

  @iOSXCUITFindBy(xpath = "//*[@name='عرض المطاعم' or @name='Find Restaurants']") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
//  @AssertElementVisibility
  private MobileElement findRestaurantsButton;

  @iOSXCUITFindBy(
      iOSClassChain = "XCUIElementTypeWindow[1]/*/*/XCUIElementTypeTabBar/XCUIElementTypeButton[1]")  //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
  @AssertElementVisibility
  private MobileElement restaurantsItem;

  @iOSXCUITFindBy(
      iOSClassChain = "XCUIElementTypeWindow[1]/*/*/XCUIElementTypeTabBar/XCUIElementTypeButton[2]")  //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
  @AssertElementVisibility
  private MobileElement ordersItem;

  @iOSXCUITFindBy(
      iOSClassChain = "XCUIElementTypeWindow[1]/*/*/XCUIElementTypeTabBar/XCUIElementTypeButton[3]")  //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
  @AssertElementVisibility
  private MobileElement offersItem;

  @iOSXCUITFindBy(
      iOSClassChain = "XCUIElementTypeWindow[1]/*/*/XCUIElementTypeTabBar/XCUIElementTypeButton[4]")  //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
  @AssertElementVisibility
  private MobileElement moreItem;

  // ToDo: find the locator of the skip promotion link in english
  // @iOSXCUITFindBy(xpath = "")  //todo:id
  @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='textInEnglish']")
  private List<WebElement> lnkSkipPromotion;

  // @iOSXCUITFindBy(id = "") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rel")
  private List<WebElement> homescreenLayout;

  /*
  =========================================================
  New Homescreen elements:
  =========================================================
   */

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/home_address_bar")
    @AssertElementVisibility
    private WebElement lstHomescreenAddress;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_location")
    @AssertElementVisibility
    private WebElement iconLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_label")
    @AssertElementVisibility
    private WebElement lblDelivery;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
    @AssertElementVisibility
    private WebElement lblDeliveryValue;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/missing_location_image")
    private List<WebElement> imgMissingLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/explanation")
    private List<WebElement> lblMissingLocExplanation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private List<WebElement> btnSetLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/banner_image")
    private List<WebElement> bannerRestuarantsGrocery;  //Homepage banners including restaurants and grocery store

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "")
    private List<WebElement> btnRestaurantsOrGrocery;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_to_label")
    private WebElement lblDeliverTo;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/new_location_clickable_view")
    private WebElement btnNewLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/row_container")
    private List<WebElement> eleLocations;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/checkbox")
    private List<WebElement> chkSelectLocation;

  public HomeScreen(AppiumDriver driver) {
    super(driver);
  }
}
