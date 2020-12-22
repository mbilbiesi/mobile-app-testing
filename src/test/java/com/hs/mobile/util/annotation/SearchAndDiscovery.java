package com.hs.mobile.util.annotation;

import io.qameta.allure.Epic;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Epic("Search & Discovery")
public @interface SearchAndDiscovery {}