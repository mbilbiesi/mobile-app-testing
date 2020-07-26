package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PaymentOptionsScreen {
    //todo implement locator
    private MobileElement btnBack;

    //todo implement locator
    private MobileElement paymentOptionsHeaderTxt;

    @iOSXCUITFindBy(accessibility = "option_credit_card")
    private MobileElement btnCreditCardPaymentOption;

    @iOSXCUITFindBy(accessibility = "paymentOptionAddCard")
    private MobileElement btnAddCard;

    @iOSXCUITFindBy(accessibility = "option_wallet")
    private MobileElement btnWalletOption;

    @iOSXCUITFindBy(accessibility = "option_voucher")
    private MobileElement btnVoucherBt;


}
