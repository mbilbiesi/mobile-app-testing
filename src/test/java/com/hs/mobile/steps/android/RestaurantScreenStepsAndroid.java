package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import lombok.NonNull;

public class RestaurantScreenStepsAndroid extends BaseSteps<RestaurantScreenStepsAndroid>
    implements RestaurantScreenSteps {

  public RestaurantScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
  }

  @Override
  public void selectRestaurantByName(String name) {}

  @Override
  public void verifyLocationIsAppearedScreenHeader() {}
}
