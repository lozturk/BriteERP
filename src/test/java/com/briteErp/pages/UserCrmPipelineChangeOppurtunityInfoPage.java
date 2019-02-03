package com.briteErp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCrmPipelineChangeOppurtunityInfoPage {

    @FindBy(linkText = "2019 Huge Sale 2")
//    (//div[@class='oe_kanban_content']//strong[@class='o_kanban_record_title'])[2]
    public WebElement newCreatedOppurtunity;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

    @FindBy(xpath = "//h1//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement infoNeededToChange;

    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

}
