package org.example.pages;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyboardSampleFormPage extends TestBase {

    //Page Factory - OR:
    @FindBy(id="userName")
    WebElement txtUserName;

    @FindBy(id="currentAddress")
    WebElement txtCurrentAddress;

    @FindBy(xpath="//textarea[@id='permanentAddress']")
    WebElement txtPermanentAddress;

    @FindBy(xpath="//input[@id='submit']")
    WebElement btnSubmit;

    //Initializing the Page Objects:
    public KeyboardSampleFormPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validatePageTitle(){
        return driver.getTitle();
    }

    public void fillForm(String userName, String currentAddress, String permanentAddress){
        txtUserName.sendKeys(userName);
        txtCurrentAddress.sendKeys(currentAddress);
        txtPermanentAddress.sendKeys(permanentAddress);
        btnSubmit.click();
        driver.switchTo().alert().accept();
    }
}