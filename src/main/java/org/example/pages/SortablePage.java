package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SortablePage extends TestBase {

    public SortablePage() {
        PageFactory.initElements(driver, this);
    }

    public void move(int targetItemByIdx, int destItemByIdx) {
        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector(".ui-sortable-handle"));
        WebElement target = list.get(targetItemByIdx);
        WebElement dest = list.get(destItemByIdx);
        action.click(target).clickAndHold().moveToElement(dest).moveByOffset(0, 1).release().build().perform();
    }
}
