package com.hs.mobile.exception;

public class TestInitializationException extends RuntimeException {
  private static final String COMMON_MSG =
      "There were issues in initializing the tests. Please look at the description below: %n%s";

  public TestInitializationException(String message) {
    super(String.format(COMMON_MSG, message));
  }

  public TestInitializationException(String message, Throwable cause) {
    super(message, cause);
  }
}
