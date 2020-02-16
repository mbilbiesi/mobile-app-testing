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

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
  @AssertElementVisibility
  private MobileElement useMyCurrentLocationText;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
  @AssertElementVisibility
  private MobileElement useMyCurrentLocationImage;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
  @AssertElementVisibility
  private MobileElement findRestaurantsButton;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
  @AssertElementVisibility
  private MobileElement restaurantsItem;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
  @AssertElementVisibility
  private MobileElement ordersItem;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
  @AssertElementVisibility
  private MobileElement offersItem;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
  @AssertElementVisibility
  private MobileElement moreItem;

  @iOSXCUITFindBy(xpath = "")
  @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='TBD']")
  private WebElement lnkSkipPromotion;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rel")
  private List<WebElement> homescreenLayout;

  public HomeScreen(AppiumDriver driver) {
    super(driver);
  }
}
