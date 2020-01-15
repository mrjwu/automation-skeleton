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

public class SwitchWindowsPage extends TestBase {

    @FindBy(xpath="//h1[@class='entry-title']")
    WebElement hdrTitlePage;

    @FindBy(xpath="//button[contains(@onclick,'newBrwWin()')]")
    WebElement btnNewBrwWin;

    @FindBy(xpath="//button[contains(@onclick,'newMsgWin()')]")
    WebElement btnNewMsgWin;

    @FindBy(xpath="//button[contains(@onclick,'newBrwTab()')]")
    WebElement btnNewBrwTab;

    @FindBy(xpath="//p[contains(text(),'I will have random ID')]")
    WebElement lblRandomId;

    @FindBy(id = "timingAlert")
    WebElement btnTimingAlert;

    public SwitchWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateHeaderTitlePage(String name){
        return hdrTitlePage.getText().trim().equals(name);
    }

    public void openNewBrwWin() {
        btnNewBrwWin.click();
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList=new ArrayList<>(handlesSet);
        System.out.println(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size() - 1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
    }

    public void openNewMsgWin() {
        btnNewMsgWin.click();
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList=new ArrayList<>(handlesSet);
        System.out.println(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size() - 1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
    }

    public void openNewBrwTab() {
        btnNewBrwTab.click();
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList=new ArrayList<>(handlesSet);
        System.out.println(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size() - 1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
    }

    public void printRandomIdElement() {
        System.out.println(lblRandomId.getAttribute("id"));
    }

    public void openTimingAlert() {
        btnTimingAlert.click();
    }

    public boolean validateAlertMessage(String name){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert().getText().trim().equals(name);
    }

    public void acceptTimingAlert() {
        driver.switchTo().alert().accept();
    }

}
