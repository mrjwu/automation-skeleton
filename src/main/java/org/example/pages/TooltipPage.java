package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TooltipPage extends TestBase {

    @FindBy(id="doubleClickBtn")
    WebElement btnDblClickMe;

    @FindBy(id="rightClickBtn")
    WebElement btnRightClickBtn;

    @FindBy(className = "contextMenuItem")
    List<WebElement> menuItemList;

    @FindBy(id="tooltipDemo")
    WebElement lblToolTip;

    @FindBy(css = ".tooltiptext")
    WebElement txtToolTip;

    public TooltipPage() {
        PageFactory.initElements(driver, this);
    }

    public void validateDoubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(btnDblClickMe).perform();
        driver.switchTo().alert().accept();
    }

    public void validateRightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(btnRightClickBtn).perform();
    }

    public void selectItemMenuByIdx(int index) {
        WebElement target = menuItemList.get(index);
        target.click();
        driver.switchTo().alert().accept();
    }

    public boolean validateToolTipText(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(lblToolTip).perform();
        return txtToolTip.getText().equals(name);
    }


}
