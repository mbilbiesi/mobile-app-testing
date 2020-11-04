package com.hs.mobile.steps;

public interface AllStoresScreenSteps {

  void selectRestaurantByName(String name);

  void verifyLocationIsAppearedScreenHeader();

  void clickOnFirstFilter();

  void assertFilterSelection();

  void deselectFilter();

  void assertFilterDeselected();
}
