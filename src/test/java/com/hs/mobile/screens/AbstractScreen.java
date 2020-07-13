package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import lombok.NonNull;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractScreen {

  @SuppressWarnings("rawtypes")
  public AbstractScreen(@NonNull TestSettings settings) {
    PageFactory.initElements(
        new AppiumFieldDecorator(settings.getDriver(), Duration.ofSeconds(15)), this);
  }
}
