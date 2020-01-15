package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.SwitchWindowsPage;
import org.example.pages.TooltipPage;
import org.example.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TooltipTest extends TestBase {
    HomePage homePage;
    TooltipPage tooltipPage;
    TestUtil testUtil;

    public TooltipTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        tooltipPage = new TooltipPage();
        homePage.goTo("Tooltip and Double click");
    }

    @Test
    public void tooltipTest() {
        tooltipPage.validateDoubleClick();

        tooltipPage.validateRightClick();
        tooltipPage.selectItemMenuByIdx(0);

        Assert.assertTrue(tooltipPage.validateToolTipText("We ask for your age only for statistical purposes."));
    }

    @AfterMethod
    public void tearDown(){

    }

}
