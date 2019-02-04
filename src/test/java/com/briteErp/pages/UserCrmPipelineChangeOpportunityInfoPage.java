package com.briteErp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCrmPipelineChangeOpportunityInfoPage {

    @FindBy(xpath = "//div[@class='o_kanban_group ui-sortable o_kanban_has_progressbar']//div[@class='oe_kanban_color_0 oe_kanban_global_click o_kanban_record ui-sortable-handle'][2]")
//    (//div[@class='oe_kanban_content']//strong[@class='o_kanban_record_title'])[2]
    public WebElement newCreatedOppurtunity;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editButton;

    @FindBy(xpath = "//h1//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement infoNeededToChange;

    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

}
