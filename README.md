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

[![How to run](https://lh6.googleusercontent.com/wlQ2LZrMC70ZYnundcpKYtOU6bFyKVLl5bTrxxDNt8XXJXBtBWCObQBJdOu_1Me58qni2-tD=w1280)](https://drive.google.com/file/d/1eEXMCLhyi9ZUecf0SZFR6q_HmIfWQQbh/view "How to run")
