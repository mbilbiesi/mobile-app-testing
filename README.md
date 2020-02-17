# Mobile Apps Testing
![workflow](https://github.com/HungerStation/mobile-apps-testing/workflows/Build%20project/badge.svg)

This project is an automation test project based on Java, TestNg and Appium which will contain automated acceptance test cases for Hungerstation mobile applications (iOS and Android).

## Getting Started
To run platform integration test project, please continue with the following sections. 

>If you could not find what you are looking for here or you are facing some difficulties setup this project please reach us via:
[Wiki](https://hungerstation.atlassian.net/wiki/spaces/HPDLC/overview).


### What you'll need

- Java IDE (Intellij)
- Appium server
- Android Virtual Device Manager (for Android Emulators)
- Xcode (for iOS emulators) 
- JDK 11 or higher
- Git (optional)
- Maven (if you need to run the project using command line)

## Running the tests

### Prerequisite 
The project in the current state require from you the following setup before triggering the tests:

##### What you need to run?
- Appium server on the default port *(http://localhost:4723/wd/hub)*
- Android or/and iOS emulator(s)

##### What you need to configure? 
You need to maintain `suite.xml` file accordingly with your emulator’s ids; this file is located in the root level of the project.

#### Run the tests
After making sure the above requirements are checked, you are now ready to go and run the tests by the following maven command:

```
mvn clean verify
```

### Where can I find the tests report?
Allure is the reporting engine configured in this project, after the tests is completed; you will find a new directory created in the root level `allure-results` includes all your test results. To be able to view the report you need to run the following command line:

```
allure serve
```

> Allure require additional configuration which can be found by following this link https://docs.qameta.io/allure/#_installing_a_commandline



### Demonstrating how to run test on android emulator 

[![How to run](https://api.media.atlassian.com/file/248af0d5-af89-425f-b10f-49e28f40bdb1/binary?token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxZDQ2ZmIxYS1lZWFhLTRmZWItYjE4OS05ZDkxYzQ0OTBkNjMiLCJhY2Nlc3MiOnsidXJuOmZpbGVzdG9yZTpmaWxlOjI0OGFmMGQ1LWFmODktNDI1Zi1iMTBmLTQ5ZTI4ZjQwYmRiMSI6WyJyZWFkIl19LCJleHAiOjE1ODE1NDU0NjksIm5iZiI6MTU4MTQ2MjQ4OX0.b2412e-0Hos80N_yR2vmbltEw3fnIAbOCWWsOYegjIQ&client=1d46fb1a-eeaa-4feb-b189-9d91c4490d63&name=poster.png)](https://api.media.atlassian.com/file/1b7b0ef1-a2d2-464b-978d-2a6bffbe4f3c/binary?token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxZDQ2ZmIxYS1lZWFhLTRmZWItYjE4OS05ZDkxYzQ0OTBkNjMiLCJhY2Nlc3MiOnsidXJuOmZpbGVzdG9yZTpmaWxlOjFiN2IwZWYxLWEyZDItNDY0Yi05NzhkLTJhNmJmZmJlNGYzYyI6WyJyZWFkIl19LCJleHAiOjE1ODE1NDUzNzgsIm5iZiI6MTU4MTQ2MjM5OH0.0IlzM2V34mWClLVkld6F4OVmddJ-KSvf1OSNjU2Aqic&client=1d46fb1a-eeaa-4feb-b189-9d91c4490d63&name=RunTest.mp4 "How to run")
