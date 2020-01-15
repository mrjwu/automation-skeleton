package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.AutoCompletePage;
import org.example.pages.HomePage;
import org.example.pages.SortablePage;
import org.example.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTest extends TestBase {
    HomePage homePage;
    AutoCompletePage autoCompletePage;
    TestUtil testUtil;

    public AutoCompleteTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        autoCompletePage = new AutoCompletePage();
        homePage.goTo("Autocomplete");
    }

    @Test
    public void autoCompleteTest() {
        autoCompletePage.enter("a");
        autoCompletePage.selectOptionWithText("Java");
    }

    @AfterMethod
    public void tearDown(){

    }

}
