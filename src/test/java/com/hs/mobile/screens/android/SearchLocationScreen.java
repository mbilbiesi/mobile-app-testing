package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class SearchLocationScreen extends AbstractScreen<SearchLocationScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_back_button")
  private MobileElement btnCancel;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_search_bar")
  private MobileElement txtSearchField;

  public SearchLocationScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
