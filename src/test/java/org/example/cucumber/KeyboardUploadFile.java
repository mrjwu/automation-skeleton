package org.example.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.KeyboardUploadPage;
import org.example.util.TestUtil;
import org.testng.Assert;

public class KeyboardUploadFile extends TestBase {

    HomePage homePage;
    KeyboardUploadPage keyboardUploadPage;
    TestUtil testUtil;

    @Given("^user goes to Home Page$")
    public void user_goes_to_home_page() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        keyboardUploadPage = new KeyboardUploadPage();

        Assert.assertTrue(homePage.validateAppLogo());
        Assert.assertTrue(homePage.validateMainNav());
        Assert.assertTrue(homePage.validateSideNav());
        Assert.assertTrue(homePage.validateEntryTitle("Home"));

    }

    @And("^goes to Upload Page$")
    public void goes_to_upload_page() {
        homePage.goTo("Keyboard Events");
        String uploadPageTitle = keyboardUploadPage.validatePageTitle();
        Assert.assertEquals(uploadPageTitle, "Keyboard Events – ToolsQA – Demo Website to Practice Automation","error message - page title is not a match");
    }

    @When("^user chooses (.+)$")
    public void user_chooses(String file) {
        keyboardUploadPage.chooseFile(file);
    }

    @Then("^clicks on upload button$")
    public void clicks_on_upload_button() {
        keyboardUploadPage.submit();
        driver.switchTo().alert().accept();
        driver.quit();
    }

}
