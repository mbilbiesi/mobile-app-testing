package com.hs.mobile.steps;

import com.hs.mobile.screens.WalletScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class WalletScreenSteps extends BaseSteps {
  private WalletScreen walletScreen;

  public WalletScreenSteps(AppiumDriver driver) {
    super(driver);
    walletScreen = new WalletScreen(driver);
  }

  @Step("Verify that all headers are displayed properly")
  public void verifyHeaders() {
    List<WebElement> headers = getAllHeaders();
    SoftAssertions soft = new SoftAssertions();

    for (WebElement header : headers) {
      soft.assertThat(isHeaderActive(header))
          .as(String.format("%s header should be properly displayed.", getHeaderText(header)))
          .isTrue();
    }

    navigateBack(2);
    soft.assertAll();
  }

  private List<WebElement> getAllHeaders() {
    List<WebElement> headers = new ArrayList<>();
    headers.add(walletScreen.getTransactionHeader());
    headers.add(walletScreen.getDateHeader());
    headers.add(walletScreen.getExpiryDateHeader());
    headers.add(walletScreen.getAmountHeader());
    return headers;
  }

  private Boolean isHeaderActive(WebElement header) {
    return isElementActive(header);
  }

  private String getHeaderText(WebElement header) {
    return getElementAttributeValue(header, TEXT);
  }
}
