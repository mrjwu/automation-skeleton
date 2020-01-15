package org.example.pages;

import org.example.base.TestBase;
import org.example.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    // CacheLookup to improve test speed
    @FindBy(xpath="//img[contains(@alt,'TOOLSQA')]")
    @CacheLookup
    WebElement imgAppLogo;

    @FindBy(xpath="//h1[@class='entry-title']")
    WebElement hdrEntryTitle;

    @FindBy(id="main")
    WebElement navMain;

    @FindBy(id="sidebar")
    WebElement navSide;

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String validatePageTitle(){
        return driver.getTitle();
    }

    public boolean validateAppLogo(){
        return imgAppLogo.isDisplayed();
    }

    public boolean validateMainNav(){
        return navMain.isDisplayed();
    }

    public boolean validateSideNav(){
        return navSide.isDisplayed();
    }

    public boolean validateEntryTitle(String name){
        return hdrEntryTitle.getText().equals(name);
    }

    public void goTo(String form) {
        WebElement desiredForm = driver.findElement(By.xpath("//a[contains(text(),'"+form+"')]"));
        //desiredForm.click();; or use JSExec as an alternative for things you can not do with Selenium
        TestUtil.clickElementByJS(desiredForm, driver);
    }
}