package com.hs.mobile.exception;

import java.util.function.Supplier;
import org.testng.TestException;

public final class ExceptionSupplier {

  private ExceptionSupplier() {}

  public static Supplier<TestInitializationException> failedToInitializeTest(String message) {
    return () -> new TestInitializationException(message);
  }

  public static Supplier<TestException> testException() {
    return () -> new TestException("failed in test");
  }

  public static Supplier<TestException> testException(String message) {
    return () -> new TestException(message);
  }
}
