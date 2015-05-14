# cucumber-sikuli-selenium-framework 
Sikuli Cucumber Gradle Test Framework Showcase

## Setup
* Java SDK 7
* Eclipse Luna
* Eclipse Plugins
  * Gradle Integration for Eclipse http://dist.springsource.com/milestone/TOOLS/gradle
 
Eclipse Setup
* Open Eclipse Luna 
* Install Plugin - Gradle Integration for Eclipse http://dist.springsource.com/milestone/TOOLS/gradle
* Restart Eclipse
* click on File -> Import -> Gradle Project
* Choose the checkout directory
* Click on "Build Model" then you will see the project in the list below, select that and click "Finish"

## Steps

* Checkout the project
* Close all Browser Windows
* On Linux/Mac run $>./gradlew cucumber
* on Windows run cmd>gradlew.bat cucumber

This should start a new Browser window, shows Google Text Search and Image Search for keyword "facebook".
The Text Search uses Selenium and the Image Search uses Sikuli.

## Architecture

The way this framework works is Feature file are run by cucumber which calls the Step Definition classes, which in turn call FlowRunner.java class, which in turn runs step.json file. In step.json file we have Actions (Selenium and Sikuli actions for verifying element/image is present, clicking them, typing in them). See BaseAction and its derived classes.

Feature File ==> Step Definitions ==> Flow.json ==> Actions

Step.json
```
[{
    "name": "Type in Google Search Text Box",
    "type": "TypeInWebElementAction",

    "selector": "id:lst-ib",
    "text": "{{text}}",
    "errorMessage": "Could not search for keyword in Google Search",
    "waitPeriodInMillis": 10000

},
{
    "name": "Click on Search Button",
    "type": "ClickWebElementAction",

    "selector": "name:btnG",
    "text": "{{text}}",
    "errorMessage": "Could not find Search Button",
    "waitPeriodInMillis": 10000

}]
```
