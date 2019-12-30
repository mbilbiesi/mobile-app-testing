package com.hs.mobile.steps;

import com.hs.mobile.screens.MenuItemScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuItemScreenSteps extends MenuItemScreen {

    public MenuItemScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("")
    public void addQuantity() {
        tap(getPlus());
    }

    @Step("")
    public Double getTotalAmount() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(getAmount()));
        String amountLabel = getAmount().getText().trim();
        return Double.parseDouble(amountLabel.substring(0, amountLabel.indexOf(' ')));
    }

    @Step("")
    public void addToCart() {
        tap(getAdd());
    }
}
