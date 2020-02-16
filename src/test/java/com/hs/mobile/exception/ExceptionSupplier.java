package com.hs.mobile.exception;

import java.util.function.Supplier;

public final class ExceptionSupplier {
  private ExceptionSupplier() {}

  public static Supplier<TestInitializationException> failedToInitializeTest(String message) {
    return () -> new TestInitializationException(message);
  }
}
