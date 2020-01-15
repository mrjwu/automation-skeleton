package org.example.pages;

import org.example.base.TestBase;
import org.example.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyboardUploadPage extends TestBase {
    @FindBy(id="browseFile")
    WebElement btnChooseFile;

    @FindBy(id="uploadButton")
    WebElement btnUploadFile;

    public KeyboardUploadPage() {
        PageFactory.initElements(driver, this);
    }

    public String validatePageTitle(){
        return driver.getTitle();
    }

    public void chooseFile(String file) {
        TestUtil.uploadFile(btnChooseFile, file);
    }

    public void submit() {
        btnUploadFile.click();
    }

}
