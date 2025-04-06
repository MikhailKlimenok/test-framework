package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentManager;
import utils.DriverFactory;

import java.lang.reflect.Method;

public class BaseTest {
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> classLevelLog = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> testLevelLog = new ThreadLocal<>();
    protected Logger logger;

    @BeforeSuite
    public void setUpSuite() {
        extent = ExtentManager.createInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        logger = LogManager.getLogger(method.getDeclaringClass());
        DriverFactory.initDriver();
        ExtentTest classLogger = extent.createTest(getClass().getSimpleName());
        classLevelLog.set(classLogger);
        ExtentTest test = classLogger.createNode(method.getName());
        testLevelLog.set(test);

        logger.info("Starting test: " + method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            testLevelLog.get().fail(result.getThrowable());
            logger.error("Test failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            testLevelLog.get().pass("Test passed");
            logger.info("Test passed: " + result.getName());
        }
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }

    protected ExtentTest getTest() {
        return testLevelLog.get();
    }
}