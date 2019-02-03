package com.briteErp.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TestBase {


    protected WebDriver driver;
    protected PageFactory pages;
    protected Actions actions;
    public SoftAssert softAssert;

    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;


    @BeforeMethod
    public void setupMethod() {
        driver = Driver.getDriver();
        pages = new PageFactory();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        // if any test fails, it can detect it,
        // take a screen shot at the point and attach to report
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtilities.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }
        Driver.closeDriver();
    }

    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        // this is our custom location of the report that will be generated
        // report will be generated in the current project inside folder: test-output
        // report file name: report.html
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";

//        windows users pls correct ur path:
//        String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";

        // initialize the htmlReporter with the path to the report
        htmlReporter = new ExtentHtmlReporter(filePath);

        // we attach the htmlreport to our report
        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

        report.setSystemInfo("QA Engineers", "Online_5");

        htmlReporter.config().setDocumentTitle("BriteERP Reports");
        htmlReporter.config().setReportName("BriteERP Automated Test Reports");

//        htmlReporter.config().setTheme(Theme.DARK);

    }

    // Method for login to CRM module as user
    public void positiveLoginTest() {

        //        1.1.1 Open the URL
        pages.login().BriteErpDemo.click();
//        1.1.2 Login using valid username and password as CRM user.
        pages.login().signIn.click();
        pages.login().email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        pages.login().password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        pages.login().loginButton.click();
//        1.1.3 Click on CRM tab on top.
        pages.login().CRMButton.click();

    }
    // Method for sending random numbers to required areas
    public String randomQuantity() {
        Random r = new Random();
        int qtty = r.nextInt(1000) + 1;
        String rndmQuantity = (" " + qtty + " ").trim();

        return rndmQuantity;
    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }
}

