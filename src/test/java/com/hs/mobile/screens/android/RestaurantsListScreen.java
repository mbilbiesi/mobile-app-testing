package com.hs.mobile.screens.android;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

@Getter
public class RestaurantsListScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_icon")
  @AssertElementVisibility
  private WebElement imgLocationIcon;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
  @AssertElementVisibility
  private WebElement eleLocationValue;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
  @AssertElementVisibility
  private WebElement txtSearchRestaurants;

  @iOSXCUITFindBy(accessibility = "Search for restaurant") // todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start")
  @AssertElementVisibility
  private WebElement imgSearchIcon;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/viewpager")
  @AssertElementVisibility
  private WebElement eleOffersContainer;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image")
  @AssertElementVisibility
  private List<WebElement> offerWidgets;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_container")
  @AssertElementVisibility
  private WebElement campaignContainer;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
  @AssertElementVisibility
  private List<MobileElement> campainBanners;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_component")
  @AssertElementVisibility
  private WebElement filtersWidget;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_filter")
  private List<WebElement> btnFilter;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
  private List<WebElement> filtersNames;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_icon")
  private List<WebElement> filtersIcons;

  // @iOSXCUITFindBy(id = "test") //Note: This element doesn't exist in iOS app
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/RestListView")
  @AssertElementVisibility
  private WebElement restaurantsListWidget;

  // @iOSXCUITFindBy(id = "test") //Note: This element doesn't exist in iOS
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantList;

  // @iOSXCUITFindBy(id = "test") //todo:id
  // Note: accessibility id exist for each restaurant, but it uses the name of the restaurant
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantWidgets;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  @AssertElementVisibility
  private List<WebElement> restaurantTitle;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  @AssertElementVisibility
  private List<WebElement> restaurantType;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/distance_value")
  private List<WebElement> restaurantDistance;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_title")
  @AssertElementVisibility
  private List<WebElement> deliveryText;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_value")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeValue;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_currency")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeCurrency;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label_desc")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfo;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfoIcon;

  // @iOSXCUITFindBy(xpath = "//*test") //todo:id
  @AndroidFindBy(xpath = "//*[@text='يوصى به' or @text='recommended']")
  private List<WebElement> recommendedBadge;

  // @iOSXCUITFindBy(xpath = "//*test") //todo:id
  @AndroidFindBy(
      xpath =
          "//*[@id='com.hungerstation.android.web.debug:id/value'"
              + " and not(@text='يوصى به' or @text='recommended')]")
  private List<WebElement> branchStatusBadge;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_end") // todo:id
  private WebElement btnClearSearchResult;

  // @iOSXCUITFindBy(xpath = "//*test") //todo:id
  @AndroidFindBy(xpath = "//*[@text='اعلان' or @text='Promoted']")
  private List<WebElement> promotedBadge;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/layout_campaign_tool_bar")
  private WebElement campaignMainImage;

  private String promotedBadgeLocator = "//*[@text='اعلان' or @text='Promoted']";

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
  @AssertElementVisibility
  private List<WebElement> restaurantListLayout;

  public RestaurantsListScreen(@NonNull TestSettings settings) {
    super(settings);
  }

  @Step("Verify that all restaurants list screen objects are displayed correctly")
  public void verifyRestaurantsListElements() {
    SoftAssertions soft = new SoftAssertions();

    Class<?> clazz = this.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(AssertElementVisibility.class)) {
        if (field.getType().isAssignableFrom(MobileElement.class)) {
          try {
            field.setAccessible(true);
            WebElement element = (WebElement) field.get(this);
            soft.assertThat(element.isDisplayed())
                .as(field.getName() + " is not displayed")
                .isTrue();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
      }
    }

    soft.assertAll();
  }
}
