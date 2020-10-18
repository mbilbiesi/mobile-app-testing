package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CheckoutScreen extends AbstractScreen<CheckoutScreen> {

  @iOSXCUITFindBy(accessibility = "hint_text")
  private MobileElement txtNoteHint;

  @iOSXCUITFindBy(accessibility = "phone_number")
  private MobileElement txtPhoneNumber;

  @iOSXCUITFindBy(accessibility = "next_button")
  private MobileElement btnNext;

  @iOSXCUITFindBy(accessibility = "code_text")
  private MobileElement txtCode;

  @iOSXCUITFindBy(accessibility = "button_title")
  private MobileElement btnPlaceOrder;

  @iOSXCUITFindBy(iOSNsPredicate = "label == ''")
  private MobileElement webTxtCheckout;

  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Continue'")
  private MobileElement webBtnContinue;

  @iOSXCUITFindBy(accessibility = "payment_change_button")
  private MobileElement btnPaymentOption;

  @iOSXCUITFindBy(accessibility = "ccv_text_field")
  private MobileElement txtCvvCode;

  @iOSXCUITFindBy(accessibility = "Done")
  private MobileElement keyboardInputDone;

  @iOSXCUITFindBy(accessibility = "Continue")
  private MobileElement btnContinue;

  @iOSXCUITFindBy(accessibility = "text_area")
  private MobileElement txtNote;

  @iOSXCUITFindBy(accessibility = "Add")
  private MobileElement btnAddNote;

  @iOSXCUITFindBy(accessibility = "Submitted")
  private MobileElement lblOrderSubmitted;

  @iOSXCUITFindBy(accessibility = "od_back")
  private MobileElement btnBack;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
  private MobileElement btnHome;

  public CheckoutScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
