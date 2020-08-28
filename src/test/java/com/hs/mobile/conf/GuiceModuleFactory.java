package com.hs.mobile.conf;

import com.google.inject.Module;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

public class GuiceModuleFactory implements IModuleFactory {

  @Override
  public Module createModule(ITestContext context, Class<?> testClass) {
    System.out.println("Parent>>>>>>" + context.getCurrentXmlTest().getParameter("deviceName"));
    return new BaseTestModule(context);
  }
}
