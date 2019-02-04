package com.briteErp.utilities;

import com.briteErp.pages.LoginPage;
import com.briteErp.pages.PipelinePage;
import com.briteErp.pages.UserCrmPipelineChangeOpportunityInfoPage;
import com.briteErp.pages.UserCrmPipelinePage;


public class PageFactory {

    private LoginPage loginPage;
    private PipelinePage pipelinePage;
    private UserCrmPipelinePage userCrmPipelinePage;
    private UserCrmPipelineChangeOpportunityInfoPage changeOpportunityInfoPage;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public PipelinePage getPipelinePage() {
        if (pipelinePage == null) {
            pipelinePage = new PipelinePage();
        }
        return pipelinePage;
    }

    public UserCrmPipelinePage userCrmPipelinePage() {
        if (userCrmPipelinePage == null) {
            userCrmPipelinePage = new UserCrmPipelinePage();
        }
        return userCrmPipelinePage;
    }

    public UserCrmPipelineChangeOpportunityInfoPage changeOpportunityInfoPage() {
        if (changeOpportunityInfoPage == null) {
            changeOpportunityInfoPage= new UserCrmPipelineChangeOpportunityInfoPage();
        }
        return changeOpportunityInfoPage;
    }

}