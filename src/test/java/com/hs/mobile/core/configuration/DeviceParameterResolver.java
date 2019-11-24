package com.hs.mobile.core.configuration;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.List;

public class DeviceParameterResolver implements ParameterResolver {
    private static int index = 0;

    public static List<DeviceCapabilities> DEVICES = List.of(
            DeviceCapabilities.builder()
                    .platformName("Android")
                    .platformVersion("10.0")
                    .udid("emulator-5554")
                    .systemPort("8201").build(),

            DeviceCapabilities.builder()
                    .platformName("Android")
                    .platformVersion("10.0")
                    .udid("emulator-5556")
                    .systemPort("8200").build()
    );

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        boolean ret = false;
        if (parameterContext.getParameter().getType() == DeviceCapabilities.class) {
            ret = true;
        }
        return ret;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Object ret = null;

        synchronized (this) {
            if (parameterContext.getParameter().getType() == DeviceCapabilities.class) {
                if (index == DEVICES.size()) index = 0;
                ret = DEVICES.get(index);
                index++;
            }
        }

        return ret;
    }
}
