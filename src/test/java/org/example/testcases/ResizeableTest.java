package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.ResizablePage;
import org.example.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResizeableTest extends TestBase {
    HomePage homePage;
    ResizablePage resizablePage;
    TestUtil testUtil;

    public ResizeableTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        resizablePage = new ResizablePage();
        homePage.goTo("Resizable");
    }

    @Test
    public void resizableTest() {
        resizablePage.resizeBoxBy(450, 300);
        resizablePage.resizeBoxBy(-600, 0);
    }

    @AfterMethod
    public void tearDown(){

    }

}
