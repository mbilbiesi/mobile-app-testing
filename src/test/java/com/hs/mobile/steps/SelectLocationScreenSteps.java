package com.hs.mobile.steps;

public interface SelectLocationScreenSteps {

  void selectCity(String cityLabel);

  void clickOnSearchIcon();

  void insertDesiredCity(String cityName);

  void enterSearch();

  void clickOnSelectAddressButton();

  void clickOnSaveForLater();

  void clickOnHomeIcon();

  void moveMapPinToNewLocationPoint();

  void clickOnDoneButton();

  void verifyNotCoveredArea();

  void clickOnSearchBarOA();

  void enterSearchAddressOA(String address);

  void clickOnSelectedAddressOA();

  void clickOnSelectOA();
}
