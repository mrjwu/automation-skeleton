package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        testUtil = new TestUtil();
    }

    @Test(priority=1)
    public void verifyHomePage(){
        String homePageTitle = homePage.validatePageTitle();
        Assert.assertEquals(homePageTitle, "ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation","error message - page title is not a match");
        Assert.assertTrue(homePage.validateAppLogo());
        Assert.assertTrue(homePage.validateMainNav());
        Assert.assertTrue(homePage.validateSideNav());
        Assert.assertTrue(homePage.validateEntryTitle("Home"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}