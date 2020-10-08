package com.hs.mobile.steps;

public interface SelectLocationScreenSteps {

  void selectCity(String cityLabel);

  void clickOnSearchIcon();

  void insertDesiredCity(String cityName);

  void enterSearch();

  void clickOnSelectAddressButton();

  void clickOnDoneButton();

  void verifyNotCoveredArea();
}
