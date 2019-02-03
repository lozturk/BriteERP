package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.PageFactory;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Random;

public class UserCRMPipelineCreateAndImportTests extends TestBase {

    @Test
    public void pipelineClickTest() {

        extentLogger = report.createTest("Pipeline Click Test");

        extentLogger.info(" 1.1.1 Open the URL");
        pages.login().BriteErpDemo.click();
        extentLogger.info("1.1.2 Login using valid username and password as CRM user.");
        pages.login().signIn.click();
        pages.login().email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        pages.login().password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        pages.login().loginButton.click();
        extentLogger.info(" 1.1.3 Click on CRM tab on top.");
        pages.login().CRMButton.click();

    }

    @Test
    public void createOpportunityTest(){
        extentLogger = report.createTest("Create an Oppurtunity as User");

//      using a method created in Testbase to login
        positiveLoginTest();

        extentLogger.info("1.2.1 Click on Create button.");
        pages.userCrmPipelinePage().createButton.click();

        extentLogger.info("1.2.2 Enter new opportunity's general information to the respective lines.");
        pages.userCrmPipelinePage().opportunityTitle.sendKeys("2019 Huge Sale");

        // COULDN'T CREATE THE CUSTOMER may be there is a bug and test should FAIL
//        Faker faker = new Faker();
//        String customerInfo = faker.company().name();
//        pages.userCrmPipelinePage().customer.sendKeys(customerInfo);
//        Select choice = new Select(pages.userCrmPipelinePage().customer);
//        choice.selectByIndex(0);
//        driver.findElement(By.xpath("(//div[@class='modal-dialog']//div[@class='modal-footer']//span[1]")).click();

        extentLogger.info("Enter Random number for expected revenue");
        pages.userCrmPipelinePage().expectedRevenue.clear();
        pages.userCrmPipelinePage().expectedRevenue.sendKeys(randomQuantity());
        pages.userCrmPipelinePage().priority.click();

        extentLogger.info("1.2.3 Save the changes by clicking create button.");
        driver.findElement(By.xpath("//footer//button[1]")).click();
    }

    @Test
    public void changeOpportunityInformation() throws InterruptedException{

        extentLogger = report.createTest("Create an Oppurtunity Information as User");

//      using a method created in Testbase to login
        positiveLoginTest();
        Thread.sleep(3000);

        extentLogger.info("1.3.1 Click on the new oppurtunity created.");
        pages.changeOppurtunityInfoPage().newCreatedOppurtunity.click();
        Thread.sleep(2000);

        extentLogger.info("1.3.2 Click on edit button");
        pages.changeOppurtunityInfoPage().editButton.click();
        Thread.sleep(2000);

        extentLogger.info("1.3.3 Change any information needed.");
        pages.changeOppurtunityInfoPage().infoNeededToChange.clear();
        Thread.sleep(2000);

        pages.changeOppurtunityInfoPage().infoNeededToChange.sendKeys("2019 Huge Sale 2");
        Thread.sleep(2000);

        extentLogger.info("1.3.4 Save the changes by clicking save button.");
        pages.changeOppurtunityInfoPage().saveButton.click();

    }

}
