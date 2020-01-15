package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends TestBase {
    public SelectablePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectFrom(int targetItemByIdx, int destItemByIdx) {
        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector(".ui-selectee"));
        WebElement target = list.get(targetItemByIdx);
        WebElement dest = list.get(destItemByIdx);
        action.clickAndHold(target).release(dest).build().perform();
    }

}
