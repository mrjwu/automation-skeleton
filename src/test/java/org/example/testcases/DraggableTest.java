package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.DraggablePage;
import org.example.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DraggableTest extends TestBase {
    HomePage homePage;
    DraggablePage draggablePage;
    TestUtil testUtil;

    public DraggableTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        draggablePage = new DraggablePage();
        homePage.goTo("Draggable");
    }

    @Test
    public void draggableTest() {
        draggablePage.dragBoxBy(300, 300);
        draggablePage.dragBoxBy(-400, -400);
    }

    @AfterMethod
    public void tearDown(){

    }

}
