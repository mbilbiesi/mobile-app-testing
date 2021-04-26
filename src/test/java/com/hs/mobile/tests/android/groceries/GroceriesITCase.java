package com.hs.mobile.tests.android.groceries;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.Groceries;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Groceries
@Feature("Groceries")
@Story("Verifying dark store elements")
@Issues({
  @Issue("HSAP-532"),
  @Issue("HSAP-531"),
  @Issue("HSAP-533"),
  @Issue("HSAP-534"),
  @Issue("HSAP-535"),
  @Issue("HSAP-556")
})

// todo: Needs maintenance
public class GroceriesITCase extends BaseTestSteps {

  @BeforeClass
  @Step("user is on groceries screen")
  public void selectCity_NavigateToGroceries() {
    // Given
    var cityToSearch = "Riyadh";

    // When
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    verticalsScreenSteps.clickOnGroceries();
  }

  @Test(description = "Verify all screen elements are displaying properly")
  public void verifyBackButton() {
    // Then
    quickMarketScreenSteps.verifyScreenElements();
  }
}
