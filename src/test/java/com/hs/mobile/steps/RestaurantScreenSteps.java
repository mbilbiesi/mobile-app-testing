package com.hs.mobile.steps;

public interface RestaurantScreenSteps {

  void selectRestaurantByName(String name);

  void verifyLocationIsAppearedScreenHeader();

  void clickOnFirstFilter();

  void assertFilterSelection();

  void deselectFilter();

  void assertFilterDeselected();
}
