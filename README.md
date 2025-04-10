# Test Automation Framework

A simple training project for practicing test automation using Selenium, TestNG, Java 24, and ExtentReports.

## Author  
**Mikhail Klimenok**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/mikhail-klimenok/)

## Key Features  
- Page Object Model structure  
- TestNG + Selenium WebDriver  
- Screenshot capture on test failure  
- HTML reports via ExtentReports  
- Custom WebDriver waits (visibility, clickability, etc.)  
- Logging with Log4j  
- Clean structure for typical web test scenarios  

## Tech Stack  
| Tool               | Purpose                    |
|--------------------|----------------------------|
| Java 24            | Programming language       |
| TestNG             | Test framework             |
| Selenium WebDriver | Browser automation         |
| Maven              | Dependency management      |
| Log4j              | Logging                    |
| ExtentReports      | HTML reporting             |
| WebDriverManager   | Driver binary management   |

## Sample Test Cases  
- `SampleTest.java` – opens Google and checks the title  
- `ThisTestWillDefinitelyFail.java` – intentionally fails (for demo purposes)  
- `GoogleSearchSuccessTest.java` – searches Google with keywords via @DataProvider  

## How to Run  
```bash
mvn clean test
```

HTML report will be saved to:  
`test-output/extent-report.html`

## CI Integration

Includes a GitHub Actions workflow:  
`.github/workflows/maven-tests.yml` — runs Maven tests on push and pull requests

## Requirements  
- Java 24+  
- Maven 3.8+  
- Latest Google Chrome  
- Internet access for live search tests

## Notes  
- If Chrome updates and you see CDP warnings, update WebDriverManager or align ChromeDriver version.  
- Some tests are meant to fail to demonstrate logging and reporting.
