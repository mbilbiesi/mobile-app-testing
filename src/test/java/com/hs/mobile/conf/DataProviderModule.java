package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.user.TestUser;
import com.hs.mobile.data.user.TestUserProvider;

@SuppressWarnings("unused")
public class DataProviderModule extends AbstractModule {

  @Provides
  @Singleton
  public TestUserProvider testUserProvider() {
    return new TestUserProvider();
  }

  @Provides
  @Singleton
  public TestUser testUser(TestUserProvider userProvider, TestSettings settings) {
    return userProvider.getUser(settings.getAssignedTestUserId());
  }
}
