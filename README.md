🧳 Make My Trip — Selenium Automation Framework
A comprehensive end-to-end test automation framework for the MakeMyTrip web application, built using Selenium WebDriver, Java, Cucumber (BDD), and TestNG, following the Page Object Model (POM) design pattern.
---
🛠️ Tech Stack
Category	Tool / Library
Language	Java
Automation Framework	Selenium WebDriver 4.11
Test Framework	TestNG 7.8, JUnit
BDD Framework	Cucumber 7.13 (Gherkin)
Build Tool	Maven
Data-Driven Testing	Apache POI (Excel - .xlsx / .xls)
Reporting	ExtentReports 5.0
Browser Management	WebDriverManager
Design Pattern	Page Object Model (POM)
---
📁 Project Structure
```
Make-My-Trip/
├── src/
│   ├── main/java/
│   │   └── pages/              # Page Object classes
│   └── test/java/
│       ├── stepDefinitions/    # Cucumber step definitions
│       ├── runner/             # TestNG/JUnit test runners
│       └── utilities/          # Reusable helper methods
├── ExcelData/                  # Test data files (.xlsx)
├── Screenshots/                # Captured failure screenshots
├── Report/                     # ExtentReports HTML reports
├── src/test/resources/
│   └── features/               # Gherkin .feature files
└── pom.xml                     # Maven dependencies
```
---
✅ Features
Page Object Model (POM) — Clean separation of page logic and test logic for maintainability and reusability
BDD with Cucumber & Gherkin — Human-readable feature files enabling collaboration between technical and non-technical stakeholders
Data-Driven Testing — Test data managed via Excel files using Apache POI, enabling wider scenario coverage without script duplication
Cross-Browser Support — Tests executable on Chrome, Firefox, and Edge using WebDriverManager for automatic driver management
Extent Reports — Rich HTML reports with pass/fail status, screenshots on failure, and test execution summary
Screenshot on Failure — Automatic screenshot capture on test failure for faster debugging
Modular & Scalable — Framework designed to easily onboard new pages and test scenarios
---
🧪 Test Scenarios Covered
Flight search — one-way and round-trip
Hotel search and listing validation
Date picker interactions
Passenger/traveller count selection
Search result validations
Cross-browser regression scenarios
---
▶️ How to Run
Prerequisites
Java 8+
Maven 3.6+
Chrome / Firefox / Edge browser installed
Run all tests
```bash
mvn test
```
Run a specific TestNG suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```
Run with a specific browser
```bash
mvn test -Dbrowser=firefox
```
---
📊 Test Reports
After execution, ExtentReports HTML report is generated at:
```
Report/ExtentReport.html
```
Open it in any browser to view detailed pass/fail results, step-level logs, and failure screenshots.
---
🔧 Configuration
Test configuration (base URL, browser, timeouts) is managed via:
```
Object.properties
```
---
👩‍💻 Author
Pradnya Khot
SDET | Selenium | Playwright | Java | BDD
https://www.linkedin.com/in/pradnya-khot-baa095208/ 
