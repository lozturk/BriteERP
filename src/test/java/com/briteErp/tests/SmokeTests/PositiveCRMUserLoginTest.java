package com.briteErp.tests.SmokeTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PositiveCRMUserLoginTest extends TestBase {

    @Test()
    public void positiveLoginTest() {
        extentLogger = report.createTest("Positive login test for Sales User level");


        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to open BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login User account");
        pages.login().login(ConfigurationReader.getProperty("CRMUserEmail"),
                ConfigurationReader.getProperty("CRMUserPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying user in CRM User account");
        assertEquals(pages.login().CRMUserText.getText(),
                ApplicationConstants.CRMUSER_ACCOUNT_NAME);
    }
}

