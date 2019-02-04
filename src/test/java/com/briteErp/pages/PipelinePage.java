package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PipelinePage extends TestBase {

    public PipelinePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pipelineXXXXX;

    public String getpipelineTitle(){
        String title = Driver.getDriver().getTitle();
     return title;
    }




}
