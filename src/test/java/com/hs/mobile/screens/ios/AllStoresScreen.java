package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AllStoresScreen {

  @iOSXCUITFindBy(accessibility = "header_back_icon")
  private MobileElement btnBack;

  @iOSXCUITFindBy(accessibility = "header_location")
  private MobileElement txtLocationHeader;

  @iOSXCUITFindBy(accessibility = "header_search_icon")
  private MobileElement btnSearchIcon;

  @iOSXCUITFindBy(accessibility = "offer_image")
  private MobileElement imgOffer;

  @iOSXCUITFindBy(accessibility = "cell_carousel")
  private MobileElement carouselCell;

  @iOSXCUITFindBy(accessibility = "filter_title")
  private MobileElement btnFilterTitle;

  // todo: filter titles by ID
  private MobileElement btnFilterAll;
  private MobileElement btnFilterFastFood;
  private MobileElement btnFilterDesert;
  private MobileElement btnFilterArabianFood;
  private MobileElement btnFilterItalian;
  private MobileElement btnFilterSandwiches;
  private MobileElement btnFilterGrills;
  private MobileElement btnFilterAsianFood;
  private MobileElement btnFilterBakery;
  private MobileElement btnFilterAmericanFood;
  private MobileElement btnFilterSeaFood;
  private MobileElement btnFilterIndianFood;
  private MobileElement btnFilterMexicanFood;
  private MobileElement btnFilterBeverages;
  private MobileElement btnFilterTurkish;
  private MobileElement btnFilterCoffee;
  private MobileElement btnFilterGrocery;

  // todo: find a unique identifier - can be applied for multiple restaurants
  private MobileElement btnSelectedRestaurant;

  // todo: look for how to generate IDs elements in each vertical

  private MobileElement firstVerticalTitle;
  private MobileElement firstVerticalStatusLabel;
}
