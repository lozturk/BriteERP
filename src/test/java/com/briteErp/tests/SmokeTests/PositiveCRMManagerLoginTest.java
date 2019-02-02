package com.briteErp.tests.SmokeTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PositiveCRMManagerLoginTest extends TestBase {

    @Test
    public void positiveLoginTest(){

        extentLogger = report.createTest("Positive Login Test for CRM Manager Level");

        extentLogger.info("Verifiying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifing to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying user is Manager account");
        assertEquals(pages.login().CRMManagerText.getText(), ApplicationConstants.CRMMANAGER_ACCOUNT_NAME);



    }


}
