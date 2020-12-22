package com.hs.mobile.steps;

public interface AllStoresScreenSteps {

  void selectRestaurantByName(String name);

  void verifyLocationIsAppearedScreenHeader();

  void clickOnFirstFilter();

  void assertFilterSelection();

  void deselectFilter();

  void assertFilterDeselected();

  void verifyCampaignBannersAreDisplayed();

  void clickOnSearch();

  void typeSearchKeyword(String searchKeyword);

  void clickOnTryOrderAnything();

  void clickOnCampaign();

  void verifyStoreSelectedIsAppeared();

  void clickOnTopPromotedStore();

  void selectStoreFromSwimlane();
}
