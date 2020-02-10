package com.hs.mobile.steps;

import com.hs.mobile.screens.MenuItemScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuItemScreenSteps {
    private MenuItemScreen menuItemScreen;
    private AppiumDriver driver;

    public MenuItemScreenSteps(AppiumDriver driver) {
        this.driver = driver;
        menuItemScreen = new MenuItemScreen(driver);
    }

    @Step("")
    public void addQuantity() {
        menuItemScreen.tap(menuItemScreen.getPlus());
    }

    @Step("")
    public Double getTotalAmount() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(menuItemScreen.getAmount()));
        String amountLabel = menuItemScreen.getAmount().getText().trim();
        return Double.parseDouble(amountLabel.substring(0, amountLabel.indexOf(' ')));
    }

    @Step("")
    public void addToCart() {
        menuItemScreen.tap(menuItemScreen.getAdd());
    }
    // todo: check why this class's steps are without description
}
