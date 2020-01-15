package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.SortablePage;
import org.example.pages.SwitchWindowsPage;
import org.example.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchWindowsTest extends TestBase {
    HomePage homePage;
    SwitchWindowsPage switchWindowsPage;
    TestUtil testUtil;

    public SwitchWindowsTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        switchWindowsPage = new SwitchWindowsPage();
        homePage.goTo("Automation Practice Switch Windows");
    }

    @Test
    public void switchingWindowsTest() {
//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));
//        switchWindowsPage.openNewBrwWin();
//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));

//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));
//        switchWindowsPage.openNewMsgWin();
//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));
//
//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));
//        switchWindowsPage.openNewBrwTab();
//        Assert.assertTrue(switchWindowsPage.validateHeaderTitlePage("Automation Practice Switch Windows"));
//
//        switchWindowsPage.printRandomIdElement();

        switchWindowsPage.openTimingAlert();
        Assert.assertTrue(switchWindowsPage.validateAlertMessage("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        switchWindowsPage.acceptTimingAlert();

    }

    @AfterMethod
    public void tearDown(){

    }

}
