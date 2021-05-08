package com.hs.mobile.core.settings;

import com.google.inject.Injector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum TestInjectors {
  INJECTORS;

  private ConcurrentMap<String, Injector> injectors = new ConcurrentHashMap<>();

  public ConcurrentMap<String, Injector> getInjectors() {
    return injectors;
  }

  public Injector getInjector(String id) {
    return injectors.get(id);
  }

  public void addInjector(String id, Injector injector) {
    injectors.putIfAbsent(id, injector);
  }
}
