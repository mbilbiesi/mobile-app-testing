package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import java.lang.reflect.Field;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

@Getter
public class RestaurantsListScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_icon")
  @AssertElementVisibility
  private WebElement imgLocationIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
  @AssertElementVisibility
  private WebElement eleLocationValue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
  @AssertElementVisibility
  private WebElement txtSearchRestaurants;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start")
  @AssertElementVisibility
  private WebElement imgSearchIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/viewpager")
  @AssertElementVisibility
  private WebElement eleOffersContainer;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image")
  @AssertElementVisibility
  private List<WebElement> offerWidgets;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_container")
  @AssertElementVisibility
  private WebElement campaignContainer;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
  @AssertElementVisibility
  private List<MobileElement> campainBanners;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_component")
  @AssertElementVisibility
  private WebElement filtersWidget;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_filter")
  private List<WebElement> btnFilter;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
  private List<WebElement> filtersNames;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_icon")
  private List<WebElement> filtersIcons;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/RestListView")
  @AssertElementVisibility
  private WebElement restaurantsListWidget;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantList;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantWidgets;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  @AssertElementVisibility
  private List<WebElement> restaurantTitle;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  @AssertElementVisibility
  private List<WebElement> restaurantType;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/distance_value")
  private List<WebElement> restaurantDistance;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_title")
  @AssertElementVisibility
  private List<WebElement> deliveryText;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_value")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeValue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_currency")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeCurrency;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label_desc")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfo;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfoIcon;

  @AndroidFindBy(xpath = "//*[@text='يوصى به' or @text='recommended']")
  private List<WebElement> recommendedBadge;

  @AndroidFindBy(
      xpath =
          "//*[@id='com.hungerstation.android.web.debug:id/value'"
              + " and not(@text='يوصى به' or @text='recommended')]")
  private List<WebElement> branchStatusBadge;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_end") // todo:id
  private WebElement btnClearSearchResult;

  @AndroidFindBy(xpath = "//*[@text='اعلان' or @text='Promoted']")
  private List<WebElement> promotedBadge;

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
      if (field.isAnnotationPresent(AssertElementVisibility.class)
          && field.getType().isAssignableFrom(MobileElement.class)) {
        try {
          field.setAccessible(true);
          WebElement element = (WebElement) field.get(this);
          soft.assertThat(element.isDisplayed()).as(field.getName() + " is not displayed").isTrue();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }

    soft.assertAll();
  }
}
