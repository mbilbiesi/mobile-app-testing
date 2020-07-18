package com.hs.mobile.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class UtilsModule extends AbstractModule {

  @Provides
  @Singleton
  public ObjectMapper jsonMapper() {
    var mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    return mapper;
  }
}
