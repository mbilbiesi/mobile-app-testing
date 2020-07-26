package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class HomeScreen {


    //DONE HOMEPAGE:


    @iOSXCUITFindBy(accessibility = "custom_button")
    private List<MobileElement> btnDifferentLocation;


    @iOSXCUITFindBy(accessibility = "delivery_to")
    private MobileElement lblDeliveryTo;

    @iOSXCUITFindBy(accessibility = "choose")
    private MobileElement lblChooseLocation;



    /*
    // todo: look for how to generate IDs elements in each vertical
     */
    private MobileElement firstVerticalTitle;
    private MobileElement firstVerticalStatusLabel;
    private MobileElement secondVerticalTitle;
    private MobileElement secondVerticalStatusLabel;
    private MobileElement thirdVerticalTitle;
    private MobileElement thirdVerticalStatusLabel;


    /*
    // todo: look for how to gather navbar buttons
    // improvement: to have all screens access this navbar
     */
    private MobileElement homeButtonNavBar; //todo: look at providing id
    private MobileElement orderButtonNavBar; //todo: look at providing id
    private MobileElement offersButtonNavBar; //todo: look at providing id
    private MobileElement moreMenuButtonNavBar; //todo: look at providing id



}
