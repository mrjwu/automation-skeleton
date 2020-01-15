package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResizablePage extends TestBase {
    @FindBy(className = "ui-resizable-se")
    WebElement resizableIcon;

    public ResizablePage() {
        PageFactory.initElements(driver, this);
    }

    public void resizeBoxBy(int coordX, int coordY) {
        Actions action = new Actions(driver);
        action.click(resizableIcon).clickAndHold().moveByOffset(coordX, coordY).release().build().perform();
    }

}
