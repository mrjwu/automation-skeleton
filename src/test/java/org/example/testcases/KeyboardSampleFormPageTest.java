package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.KeyboardSampleFormPage;
import org.example.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KeyboardSampleFormPageTest extends TestBase {
    HomePage homePage;
    KeyboardSampleFormPage keyboardSampleFormPage;
    TestUtil testUtil;
    String sheetName = "demo";

    public KeyboardSampleFormPageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        keyboardSampleFormPage = new KeyboardSampleFormPage();
    }

    @Test(priority=1)
    public void verifyPageTitleTest(){
        homePage.goTo("Keyboard Events Sample Form");
        String keyboardSampleFormPageTitle = keyboardSampleFormPage.validatePageTitle();
        Assert.assertEquals(keyboardSampleFormPageTitle, "Keyboard Events Sample Form – ToolsQA – Demo Website to Practice Automation","error message - page title is not a match");
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority=2, dataProvider="getTestData")
    public void verifyFormFilled(String userName, String currentAddress, String permanentAddress){
        //prop.getProperty("username")
        homePage.goTo("Keyboard Events Sample Form");
        keyboardSampleFormPage.fillForm(userName, currentAddress, permanentAddress);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}