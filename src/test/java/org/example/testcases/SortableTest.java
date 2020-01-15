package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.SortablePage;
import org.example.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SortableTest extends TestBase {
    HomePage homePage;
    SortablePage sortablePage;
    TestUtil testUtil;

    public SortableTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        sortablePage = new SortablePage();
        homePage.goTo("Sortable");
    }

    @Test
    public void sortableTest() {
        sortablePage.move(0,2);
        sortablePage.move(3,5);
    }

    @AfterMethod
    public void tearDown(){

    }

}
