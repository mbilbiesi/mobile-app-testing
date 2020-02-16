package com.hs.mobile.steps;

import com.hs.mobile.screens.MenuItemScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuItemScreenSteps extends BaseSteps {
    private MenuItemScreen menuItemScreen;

    public MenuItemScreenSteps(AppiumDriver driver) {
        super(driver);
        menuItemScreen = new MenuItemScreen(driver);
    }

    @Step("")
    public void addQuantity() {
        tap(menuItemScreen.getPlus());
    }

    @Step("")
    public Double getTotalAmount() {
        wait.until(ExpectedConditions.visibilityOf(menuItemScreen.getAmount()));
        String amountLabel = menuItemScreen.getAmount().getText().trim();
        return Double.parseDouble(amountLabel.substring(0, amountLabel.indexOf(' ')));
    }

    @Step("")
    public void addToCart() {
        tap(menuItemScreen.getAdd());
    }
    // todo: check why this class's steps are without description
}
