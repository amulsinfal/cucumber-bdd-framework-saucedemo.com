# Cucumber Automation Project - Saucedemo [Cucumber | Selenium | Java | POM | TestNG | Maven ]

### 🌟 Project Title: 
Automation framework for testing of [Saucedemo](https://www.saucedemo.com/) using BDD framework.

### ⚡️ Project Overview:
This project aims to create an automated testing framework using the cucumber tool, selenium automation tool, Java as the programming language, TestNG testing framework, and following the Page Object Model (POM) design pattern. The target application for this project is the [Saucedemo](https://www.saucedemo.com/), which is a demo online ecommerce site for practicing and learning test automation.<br> 
<img width="1164" alt="" src="https://github.com/user-attachments/assets/1ae7b065-e209-4cee-89da-d0ad24033fa7">

## ⚙️ Tools, Languages Frameworks used:

The project uses the following tools, frameworks:

| # | Tech/Tools | Name | Version |
| -------- |-------- | -------- | -------- |
| 1 | Programming language    | Java    | 21.0.6    | 
| 2 | Automation tool    | Selenium webdriver     | 4.33.0     |
| 3 | Testing framework | Cucumber	| 7.22.1 |
| 4 | Build Tool | Maven | 3.9.9 |
| 5 | IDE | Eclipse | 2025-03(4.35.0) |
| 6 | Reporting tool | Log4j2 | 2.24.3 |

 
## 📜 Project Structure : 
Following is the folder structure for this project : <br>

<img width="500" alt="" src="https://github.com/user-attachments/assets/ef443b86-ee98-4a26-a6a8-5f4d83f675e2">

## 📜 Dependency using in the project:
The following dependencies are added to the 'pom.xml' file for this Cucumber BDD framework:

| # |  Name         | Version   | Purpose                          |
|---|--------------------------|-----------|----------------------------------|
| 1 | Selenium Java            | 4.32.0    | Browser automation               |
| 2 | Cucumber Java            | 7.22.1    | Step definitions and hooks       |
| 3 | Cucumber Core            | 7.22.1    | Core BDD functionality           |
| 4 | Cucumber TestNG          | 7.22.1    | Integrates Cucumber with TestNG  |
| 5 | Log4j Core               | 2.24.3    | Logging core library             |
| 6 | Log4j API                | 2.24.3    | Logging API interface            |

![cucumber-bdd-automation-framework-saucedemo.com-dependencies](https://github.com/user-attachments/assets/ee1f2da0-ee0b-439b-8352-ddd35cfc8c69)


## 📜 Design Pattern used - Page Object Model:

**Page Object Model (POM)**: Implement the POM design pattern. This pattern involves creating separate classes for each distinct page or section of the website under test.<br>

**Page Classes**: Each page class encapsulates the web elements and methods required to interact with those elements on that specific page. This separation improves code maintainability.

📁 Location: <br>
Pages classes are saved under following path : ['cucumber-bdd-framework-saucedemo.com/src/main/java/pages/'](src/main/java/pages) <br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/e887565d-76d0-4950-a1c6-6942500aea82">

## ⚙️ Configuration File: 'configuration.properties'

This project uses a **configuration.properties** file to manage environment-specific settings and test parameters centrally. This allows easy modification of key values without changing the code.

### 🔑 Common Configuration Parameters:

| Property Key      | Description                          | Example Value                |
|-------------------|--------------------------------------|------------------------------|
| 'browser'         | Browser to run tests on              | 'chrome'                     |
| 'testUrl'         | Application URL under test           | 'https://www.saucedemo.com/' |
| 'implicitWait'    | Implicit wait time in seconds        | '5'                          |
| 'explicitWait'    | Explicit wait time in seconds        | '15'          		            |
| 'pageLoadTimeout' | Maximum page load timeout in seconds | '10'                         |

📁 Location:  
Configuration file is saved under following path : ["cucumber-bdd-framework-saucedemo.com/src/test/resources/configurations/configuration.properties"](src/test/resources/configurations)  
📄 View source: [config.properties.java](src/test/resources/configurations/config.properties)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/820a2f2f-825d-44a1-972a-45d27431284a">

## 🔧 Utility Classes

The 'Utilities' package contains commonly used helper classes and configuration readers that improve modularity and reduce code duplication across the framework.

📂 Location:  
Utilities classes are saved under following path : ['cucumber-bdd-framework-saucedemo.com/src/main/java/utilities/'](src/main/java/utilities)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/91824d3f-d308-49bd-b78e-a5fd9710b2f3">

### ⚙️ 1. ConfigReader.java

**Purpose:**  
Responsible for reading test configuration data from 'config.properties' file. It loads essential values like:
- Base URL
- Browser type
- Timeout durations

This promotes a clean separation between configuration and logic.  
📄 View source: [ConfigReader.java](src/main/java/utilities/ConfigReader.java)

These utility classes help make the automation framework scalable, maintainable, and robust by centralizing common functionality.

## 📜 Test cases :
This project follows Behavior Driven Development (BDD) using Cucumber with Selenium WebDriver. Each user scenario is defined in '.feature' files using Gherkin syntax and implemented in Java step definitions.

### 📁 1. Feature Files

**List of Feature Files:**

| Feature File              | Description                                                                                  | Link                                                                               |
| ------------------------- | -------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| Login.feature             | Scenarios for valid & invalid login, locked out user, blank field validations                | [Login.feature](src/test/resources/features/Login.feature)                         |
| Logout.feature            | Scenarios for logout visibility and functionality from sidebar menu                          | [Logout.feature](src/test/resources/features/Logout.feature)                       |
| Products.feature          | Scenarios for product listing, description, price, and cart badge validation                 | [Products.feature](src/test/resources/features/Products.feature)                   |
| ProductDetails.feature    | Scenarios for product detail page verification (name, description, price)                    | [ProductDetails.feature](src/test/resources/features/ProductDetails.feature)       |
| Cart.feature              | Scenarios for cart navigation, item add/remove, quantity, UI elements                        | [Cart.feature](src/test/resources/features/Cart.feature)                           |
| Checkout.feature          | Scenarios for checkout form input, validation messages, navigation                           | [Checkout.feature](src/test/resources/features/Checkout.feature)                   |
| CheckoutOverview.feature  | Scenarios for overview page validation: product, tax, subtotal, total, cancel/finish buttons | [CheckoutOverview.feature](src/test/resources/features/CheckoutOverview.feature)   |
| CheckoutComplete.feature  | Scenarios for confirmation message and back-to-home redirection after order completion       | [CheckoutCompleted.feature](src/test/resources/features/CheckoutComplete.feature)  |

📌 All scenarios are grouped using Cucumber tags like @Smoke, @Sanity, @Regression, and can be executed via TestNG runners

All Cucumber '.feature' files are saved under the following directory in this project:  
['cucumber-bdd-framework-saucedemo.com/src/test/resources/features/'](src/test/resources/features)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/b3f516a0-5027-4cbd-be6d-51ca4176d644">

### 📂 2. Step Definitions

**List of Step Definition Files:**

| Step File                   | Description                                        | Link                                                                                                                                                                   |
| --------------------------- | -------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| LoginSteps.java             | Step implementations for Login.feature             | [LoginSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/LoginSteps.java)                        |
| LogoutSteps.java            | Step implementations for Logout.feature            | [LogoutSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/LogoutSteps.java)                      |
| ProductsSteps.java          | Step implementations for Products.feature          | [ProductsSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/ProductsSteps.java)                  |
| ProductDetailsSteps.java    | Step implementations for ProductDetails.feature    | [ProductDetailsSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/ProductDetailsSteps.java)        |
| CartSteps.java              | Step implementations for Cart.feature              | [CartSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/CartSteps.java)                          |
| CheckoutSteps.java          | Step implementations for Checkout.feature          | [CheckoutSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/CheckoutSteps.java)                  |
| CheckoutOverviewSteps.java  | Step implementations for CheckoutOverview.feature  | [CheckoutOverviewSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/CheckoutOverviewSteps.java)  |
| CheckoutCompleteSteps.java  | Step implementations for CheckoutComplete.feature  | [CheckoutCompleteSteps.java](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/blob/master/src/test/java/stepdefinitions/CheckoutCompletedStes.java)  |

Step definitions implement the logic for each Gherkin step in the feature files.  
They are located at:  
['cucumber-bdd-framework-saucedemo.com/src/test/java/stepdefinitions/'](src/test/java/stepdefinitions)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/6c96f0e5-34c9-47e4-ab26-46bfa0224fb5">

### ✅ 3. Test Scenarios Covered

Below are the high-level test scenarios automated in this project:

LOGIN TEST CASES:
1. Test to verify user is able to login successfully with valid username and password.
2. Test to verify error message when invalid username and invalid password is entered.
3. Test to verify error message when locked out username and valid password is entered.
4. Test to verify error message when both username and password are left blank.

LOGOUT TEST CASES:
1. Test to verify logout button is visible in the sidebar menu.
2. Test to verify user is successfully logged out using the sidebar menu.

PRODUCTS TEST CASES:
1. Test to verify a product is listed on the Products page.
2. Test to verify clicking Product item title navigates to item detail page.
3. Test to verify product description for a product on the Products Page.
4. Test to verify product price for a product on the Products Page.
5. Test to verify cart badge shows correct item count after adding a product.

PRODUCT DETAIL TEST CASES:
1. Test to verify product name matches in Product details page.
2. Test to verify product description matches in Product details page.
3. Test to verify product price matches in Product details page.

CHECKOUT TEST:
1. Test to verify user can enter First Name, Last Name, and Zip Code.
2. Test to verify error message when First Name is missing in checkout form.
3. Test to verify error message when Last Name is missing in checkout form.
4. Test to verify error message when Zip/Postal Code is missing in checkout form.
5. Test to verify Cancel button on checkout info page navigates back to cart.

CHECKOUT OVERVIEW TEST:
1. Test to verify product and details are correctly displayed on overview page.
2. Test to verify tax is displayed correctly.
3. Test to verify subtotal is displayed correctly.
4. Test to verify Total is displayed correctly.
5. Test to verify Cancel button on overview page returns user to cart.
6. Test to verify Finish button completes the checkout process.

CHECKOUT COMPLETE TEST:
1. Test to verify success message is shown after order completion
2. Test to verify Back Home button redirects to inventory page

## 🔗 Hooks

The framework utilizes **Cucumber Hooks** ('@Before' and '@After') to manage pre- and post-test execution tasks across all scenarios.

### ✅ Purpose of Hooks:

Hooks are defined in a separate 'Hooks.java' class and help with:
- 🔧 Initializing the WebDriver before each scenario
- 🧹 Quitting the browser after each scenario
- 📸 Capturing screenshots on test failure
- 🗂 Loading configuration before test execution (e.g., from 'ConfigReader')

📂 Location:  
Hook classes are saved under following path : ['cucumber-bdd-framework-saucedemo.com/src/test/java/hooks/'](src/test/java/hooks)
<img width="500" alt="" src="https://github.com/user-attachments/assets/f0975ac6-5350-4375-b2bf-da781959859a">

📄 View source: ['cucumber-bdd-framework-saucedemo.com/src/test/java/hooks/CucumberHooks.java'](src/test/java/hooks/CucumberHooks.java)


## 🚀 Test Runner

The **TestNgRunner** class is the main entry point for executing the Cucumber feature files. It is configured using the and '@CucumberOptions' annotations.

📂 Location:  
Runner class "TestNgRunner" file is saved under following path : ['cucumber-bdd-framework-saucedemo.com/src/test/java/runner'](src/test/java/runner)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/a3b0ecc8-06d3-49c2-b8fd-10ef6af2f432">

📄 View source: ['cucumber-bdd-framework-saucedemo.com/src/test/java/runner/TestRunner.java'](src/test/java/runner/TestNgRunner.java)

## 📜 Reporting

This project uses **Cucumber HTML Reports** to generate detailed test execution reports for each scenario defined in the '.feature' files.

### ✅ Report Features:
- Lists all scenarios with pass/fail status
- Step-by-step execution flow
- Scenario tags, keywords, and duration
- Summary of total scenarios passed, failed, and skipped
- Rich and user-friendly UI

📂 Location:  
After running the test suite, the report is automatically generated at the following path : ['cucumber-bdd-framework-saucedemo.com/reports/CucumberReports/'](reports/CucumberReports)

<img width="500" alt="" src="https://github.com/user-attachments/assets/fd8b387d-7c19-4faa-99ae-f9fe28ecd792">  
<img width="1164" alt="" src="https://github.com/user-attachments/assets/848ac409-866a-4de7-ba02-81aed06a0441">  


## 🏃 Running the project:

### 🧪 Cloning the repository:
1. Clone [cucumber-bdd-framework-saucedemo.com](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com.git) project from Github<br> 
  ```
    git clone https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com.git
  ```
2. Navigate to the cloned directory<br> 
  ```
    cd cucumber-bdd-framework-saucedemo.com
  ```   
3. Compile maven dependencies<br> 
  ```
    $ mvn compile
  ```
  
### Running the Tests:
Run the Cucumber tests using Maven command:<br>
```
mvn test
```
or  
Double click to run the "Run.bat" file.  
<img width="500" alt="" src="https://github.com/user-attachments/assets/dcb4fc57-6538-44ed-bf5c-74de748e4302">  
![cucumber-bdd-framework-saucedemo.com-run-bat-console-output](https://github.com/user-attachments/assets/a727bbbe-56f0-4a4b-ac6d-c6fbc3f503b3)

This will execute all feature files and generate the test reports.

### 📝 Notes:
- Make sure you have **Java** and **Maven** installed and configured in your system's PATH.
- You can customize browser and environment settings in the [config.properties](src/test/resources/configurations/config.properties) file via the 'ConfigReader' utility before running tests.

## 🎥 Test Execution Demo
Video File name: cucumber-bdd-framework-saucedemo-com-execution-video.mp4
Test execution video file path: [cucumber-bdd-framework-saucedemo.com-execution-video](https://github.com/amulsinfal/cucumber-bdd-framework-saucedemo.com/tree/main/recording)
