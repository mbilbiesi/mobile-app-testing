package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AllStoresScreen {

    @iOSXCUITFindBy(accessibility = "header_back_icon")
    private MobileElement btnBack;

    @iOSXCUITFindBy(accessibility = "header_back_icon")
    private MobileElement lblChooseLocation;

    @iOSXCUITFindBy(accessibility = "header_location")
    private MobileElement txtLocationHeaderTxt;

    @iOSXCUITFindBy(accessibility = "header_search_icon")
    private MobileElement btnSearchIcon;

    @iOSXCUITFindBy(accessibility = "cell_carousel")
    private MobileElement carouselCell;

    @iOSXCUITFindBy(accessibility = "filter_title")
    private MobileElement ClickableFilterTitle;

    //todo: filter titles by ID
    private MobileElement filterAll;
    private MobileElement filterFastFood;
    private MobileElement filterDesert;
    private MobileElement filterArabianFood;
    private MobileElement filterItalian;
    private MobileElement filterSandwiches;
    private MobileElement filterGrills;
    private MobileElement filterAsianFood;
    private MobileElement filterBakery;
    private MobileElement filterAmericanFood;
    private MobileElement filterSeaFood;
    private MobileElement filterIndianFood;
    private MobileElement filterMexicanFood;
    private MobileElement filterBeverages;
    private MobileElement filterTurkish;
    private MobileElement filterCoffee;
    private MobileElement filterGrocery;


    //TODO: find a unique identifier - can be applied for multiple restaurants
    private MobileElement restaurantBtn;

    /*
    // todo: look for how to generate IDs elements in each vertical
     */
    private MobileElement firstVerticalTitle;
    private MobileElement firstVerticalStatusLabel;
}
