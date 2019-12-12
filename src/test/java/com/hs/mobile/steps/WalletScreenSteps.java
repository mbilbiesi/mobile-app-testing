package com.hs.mobile.steps;

import com.hs.mobile.screens.WalletScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class WalletScreenSteps extends WalletScreen {

    public WalletScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that all headers are displayed properly")
    public void verifyHeaders() {
        List<WebElement> headers = getAllHeaders();
        SoftAssertions assertions = new SoftAssertions();

        for (WebElement header : headers) {
            assertions
                    .assertThat(isHeaderActive(header))
                    .as(String.format("%s header should be properly displayed.", getHeaderText(header)))
                    .isTrue();
        }

        driver.navigate().back();
        driver.navigate().back();
        assertions.assertAll();
    }

    private List<WebElement> getAllHeaders() {
        List<WebElement> headers = new ArrayList<>();
        headers.add(getTransactionHeader());
        headers.add(getDateHeader());
        headers.add(getExpiryDateHeader());
        headers.add(getAmountHeader());
        return headers;
    }

    private Boolean isHeaderActive(WebElement header) {
        return isElementActive(header);
    }

    private String getHeaderText(WebElement header) {
        return getElementAttributeValue(header, TEXT);
    }
}
