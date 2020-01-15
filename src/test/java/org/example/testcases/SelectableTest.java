package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.SelectablePage;
import org.example.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTest extends TestBase {
    HomePage homePage;
    SelectablePage selectablePage;
    TestUtil testUtil;

    public SelectableTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        selectablePage = new SelectablePage();
        homePage.goTo("Selectable");
    }

    @Test
    public void selectableTest() {
        selectablePage.selectFrom(0,2);
        selectablePage.selectFrom(3,5);
    }

    @AfterMethod
    public void tearDown(){

    }

}
