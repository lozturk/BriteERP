package com.briteErp.utilities;

import com.briteErp.pages.*;
import com.briteErp.pages.LoginPage;

public class PageFactory {

    private LoginPage loginPage;
    private PipelinePage pipelinePage;
//    private CatalogPage catalogPage;
//    private OrdersPage ordersPage;
//    private ConfigurationPage configurationPage;
//    private ReportingPage reportingPage;

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
//
//    public CatalogPage getCatalogPage() {
//        if (catalogPage == null) {
//            catalogPage = new CatalogPage();
//        }
//        return catalogPage;
//    }
//
//    public OrdersPage getOrdersPage() {
//        if (ordersPage == null) {
//            ordersPage = new OrdersPage();
//        }
//        return ordersPage;
//    }
//
//    public ConfigurationPage getConfigurationPage() {
//        if (configurationPage == null) {
//            configurationPage = new ConfigurationPage();
//        }
//        return configurationPage;
//    }
//
//    public ReportingPage getReportingPage () {
//        if (reportingPage == null) {
//            reportingPage = new ReportingPage();
//        }
//        return reportingPage;
//    }
}