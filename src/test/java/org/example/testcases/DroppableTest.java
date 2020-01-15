package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.DroppablePage;
import org.example.pages.HomePage;
import org.example.pages.SortablePage;
import org.example.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase {
    HomePage homePage;
    DroppablePage droppablePage;
    TestUtil testUtil;

    public DroppableTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        droppablePage = new DroppablePage();
        homePage.goTo("Droppable");
    }

    @Test
    public void droppableTest() {
        String beforeColor = droppablePage.getColor();
        droppablePage.move();
        String afterColor = droppablePage.getColor();
        Assert.assertNotEquals(beforeColor, afterColor);
    }

    @AfterMethod
    public void tearDown(){

    }

}
