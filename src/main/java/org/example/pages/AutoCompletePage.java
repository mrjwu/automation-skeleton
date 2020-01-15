package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class AutoCompletePage extends TestBase {

    @FindBy(id="tags")
    WebElement txtTags;

    @FindBy(id="ui-id-1")
    WebElement autoOptions;


    public AutoCompletePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectOptionWithText(String textToSelect) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(autoOptions));
        List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));

        try {
            for(WebElement option : optionsToSelect){
                if(option.getText().equals(textToSelect)) {
                    System.out.println("Trying to select: "+textToSelect);
                    option.click();
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void enter(String query) {
        txtTags.sendKeys(query);
    }



}
