package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DroppablePage extends TestBase {

    @FindBy(id="draggable")
    WebElement boxDraggable;

    @FindBy(id="droppable")
    WebElement boxDroppable;

    public DroppablePage() {
        PageFactory.initElements(driver, this);
    }

    public void move() {
        Actions action = new Actions(driver);
        action.click(boxDraggable).clickAndHold().moveToElement(boxDroppable).moveByOffset(0, 1).release().build().perform();
    }

    public String getColor() {
        return boxDroppable.getCssValue("color");
    }
}
