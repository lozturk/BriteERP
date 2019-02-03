package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CRMmanagerPipelineTest extends TestBase {

    @Test
    public void BRIT_1408(){

    extentLogger = report.createTest("CRM Manager should be able to " +
            "navigate pipeline functionality(BRIT-1408)");

    extentLogger.info("Verifying to open main page");
    pages.login().open();

    extentLogger.info("Verifying to select BriteErpDemo");
    pages.login().selectBriteErpDemo();

    extentLogger.info("Verifying to login Manager account");
    pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
            ConfigurationReader.getProperty("CRMManagerPassword"));

    extentLogger.info("Verifing to open CRM module page is ready for usage");
    pages.login().clickCRModule();

    extentLogger.info("Verifying the Pipeline page is ready for usage");
    softAssert.assertEquals(pages.getPipelinePage().getpipelineTitle(), ApplicationConstants.PIPELINE_TITLE);

    extentLogger.info("Verifying the Pipeline func. is clickable");
    //softAssert.assertEquals(pages.getPipelinePage().getpipelineTitle(),ApplicationConstants.PIPELINE_TITLE);

    }


}
