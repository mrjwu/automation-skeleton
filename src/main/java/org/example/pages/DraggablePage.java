package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage extends TestBase {

    @FindBy(id="draggable")
    WebElement boxDraggable;

    public DraggablePage() {
        PageFactory.initElements(driver, this);
    }

    public void dragBoxBy(int coordX, int coordY) {
        Actions action = new Actions(driver);
        action.click(boxDraggable).clickAndHold().moveByOffset(coordX, coordY).release().build().perform();
    }
}
