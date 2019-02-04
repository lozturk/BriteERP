package com.briteErp.tests.SmokeTests;


import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

import static com.briteErp.utilities.ApplicationConstants.*;
import static org.testng.Assert.assertEquals;

public class NegativeCRMManagerLoginTest extends TestBase {

    @Test(priority = 1)
    public void wrongEmailTest(){
        extentLogger = report.createTest("Wrong email test for CRM Manager level");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to open BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerWrongEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));
        //Thread.sleep(5000);
        String actualError = pages.login().errorMessage.getText();

        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger.pass("Passed:Wrong email test");
    }

    @Test(priority = 2)
    public void wrongPasswordTest(){
        extentLogger = report.createTest("Wrong password test for CRM Manager level");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to open BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerWrongPassword"));

        String actualError = pages.login().errorMessage.getText();

        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_ERROR_MESSAGE);
        extentLogger .pass("Passed:Wrong password test");
    }

    @Test(priority = 3)
    public void blankEmailTest() {
        extentLogger = report.createTest("Blank email test for CRM Manager level");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to open BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerBlankEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        String actualError = pages.login().email.getText();

        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_EMPTY_EMAIL);
        extentLogger .pass("Passed:Blank email test");
    }

    @Test(priority = 4)
    public void blankPasswordTest(){
        extentLogger = report.createTest("Blank password test for Sales Manager level");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to open BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerBlankPassword"));

        String actualError = pages.login().password.getText();

        extentLogger.info("Verifying error message");
        assertEquals(actualError, LOGIN_EMPTY_PASSWORD);
        extentLogger .pass("Passed:Blank password test");
    }

}


