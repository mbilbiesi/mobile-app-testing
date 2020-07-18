package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.settings.TestParameters;
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
  public TestUser testUser(TestUserProvider userProvider, TestParameters testParameters) {
    return userProvider.getUser(testParameters.getAssignedTestUserId());
  }
}
