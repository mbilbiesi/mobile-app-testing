package com.hs.mobile.screens.android;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class LandingScreen extends AbstractScreen<LandingScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
  private MobileElement useMyCurrentLocationText;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
  private MobileElement useMyCurrentLocationImage;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
  private MobileElement findRestaurantsButton;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
  @AssertElementVisibility
  private MobileElement restaurantsItem;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
  @AssertElementVisibility
  private MobileElement ordersItem;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
  @AssertElementVisibility
  private MobileElement offersItem;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
  @AssertElementVisibility
  private MobileElement moreItem;

  @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='textInEnglish']")
  private WebElement lnkSkipPromotion;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rel")
  private List<WebElement> homeScreenLayout;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/home_address_bar")
  @AssertElementVisibility
  private WebElement lstHomeScreenAddresses;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_location")
  @AssertElementVisibility
  private WebElement iconLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_label")
  @AssertElementVisibility
  private WebElement lblDelivery;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  @AssertElementVisibility
  private WebElement lblDeliveryValue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/missing_location_image")
  private List<WebElement> imgMissingLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/explanation")
  private List<WebElement> lblMissingLocExplanation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private List<WebElement> btnSetLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/banner_image")
  private List<WebElement> bannerRestaurantsGrocery;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private List<WebElement> btnRestaurantsOrGrocery;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_to_label")
  private WebElement lblDeliverToDeliverTo;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/new_location_clickable_view")
  private WebElement btnNewLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/row_container")
  private List<WebElement> savedLocations;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/checkbox")
  private List<WebElement> chkSelectLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/overflow_icon")
  private List<WebElement> btnMore;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/content")
  private List<WebElement> btnEditOrDelete;

  public LandingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
