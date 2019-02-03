package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCrmPipelinePage {

    public UserCrmPipelinePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='crm.menu_crm_opportunities']")
    public WebElement pipelineLink;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']")
    public WebElement createButton;

    @FindBy(xpath = "//td//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement opportunityTitle;

    @FindBy(xpath = "(//div[@class='o_input_dropdown']//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement customer;

    @FindBy(xpath = "//div[@class='o_row']//input[@class='o_field_float o_field_number o_field_widget o_input']")
    public WebElement expectedRevenue;

    @FindBy(xpath = "//tbody//tr[4]//td[2]//div//a[2]")
    public WebElement priority;

    @FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement xIconOnSearchBox;






}
