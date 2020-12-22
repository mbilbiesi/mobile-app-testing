package com.hs.mobile.steps;

public interface LandingScreenSteps {

  void handleLocationPopup();

  void handlePromotionPopup();

  void selectNewAddress();

  void clickOnMore();

  void clickOnMoreActions();

  String getAddressLabel();

  void clickOnEditAddress();

  void clickOnDeleteAddress();

  void confirmRemoveAddress();

  void verifySearchFieldValueIsEqualTo(String value);

  void clickOnOrders();
}
