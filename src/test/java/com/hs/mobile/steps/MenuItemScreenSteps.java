package com.hs.mobile.steps;

public interface MenuItemScreenSteps {

  void addMoreItems(int itemsCounter);

  void addToCart();

  void verifyViewCartButtonIsDisplayed();

  void clickOnViewCart();

  void verifyCaloriesLabel();

  void clickOnMenuSearchIcon();

  void searchForMenuItem(String menuItem);

  void clickSearchResultItem();

  void clickCancelSearch();

  void clickOnCheckoutFromMenuScreen();
}
