# Test Automation Framework

A modern, lightweight test automation framework for UI testing using **Selenium**, **TestNG**, **Java 24**, and **ExtentReports**.

Author: **Mikhail Klimenok**

## ✅ Features

- 🧪 **Test Framework** based on **TestNG**
- 🌐 **Selenium WebDriver** with support for Google Chrome
- 💡 **Page Object Model (POM)** structure
- 📸 **Screenshot capture** on test failure
- 📊 **HTML reports** via **ExtentReports**
- 🔁 **Retry logic** for flaky tests (via `IRetryAnalyzer`)
- 🔍 **Custom WebDriver waits** (e.g. for visibility or clickability)
- 🧾 **Logging** with **Log4j**
- 📁 Project structure optimized for real-world web UI test cases

## 🧠 Tech Stack

| Tool              | Purpose                             |
|-------------------|-------------------------------------|
| Java 24           | Programming language                |
| TestNG            | Test runner & annotations           |
| Selenium WebDriver| UI automation                       |
| Maven             | Dependency management               |
| Log4j             | Logging                             |
| ExtentReports     | Test reporting                      |
| WebDriverManager  | Driver binaries management          |

## 📂 Project Structure

```
test-framework/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── base/           # Base classes
│       │   ├── pages/          # Page Object classes
│       │   ├── tests/          # Test cases
│       │   ├── utils/          # Utility classes (e.g. waits, configs)
│       │   └── report/         # Extent report setup
│       └── resources/          # Config files (e.g. testng.xml)
├── pom.xml                    # Maven config
└── README.md                  # This file
```

## 🧪 Sample Test Cases

- ✅ `SampleTest.java` – opens Google and verifies the page
- ❌ `ThisTestWillDefinitelyFail.java` – always fails by trying to find a nonexistent element
- ✅ `GoogleSearchSuccessTest.java` – performs a Google search for different keywords using `@DataProvider`

## ▶️ Running Tests

```bash
mvn clean test
```

Test results are printed to the console, and HTML reports are saved to:

```
test-framework/target/ExtentReports/
```

## 🛠 Prerequisites

- Java 24+
- Maven 3.8+
- Google Chrome (latest)
- Internet access for actual search tests

## 📌 Notes

- If Chrome updates and you encounter `CDP version` warnings, update `WebDriverManager` or match your ChromeDriver version.
- Some test cases are intentionally designed to fail (e.g., to demonstrate logging/reporting).

---

Happy Testing! 🧪
