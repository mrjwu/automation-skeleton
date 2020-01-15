package org.example.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.example.base.TestBase;
import org.example.pages.HomePage;
import org.example.pages.KeyboardSampleFormPage;
import org.example.util.TestUtil;
import org.testng.Assert;

public class KeyboardSampleForm extends TestBase {

    HomePage homePage;
    KeyboardSampleFormPage keyboardSampleFormPage;
    TestUtil testUtil;
    String sheetName = "demo";

    public KeyboardSampleForm() {
        super();
    }

    @Given("^user is already on Home Page$")
    public void user_is_already_on_home_page() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        keyboardSampleFormPage = new KeyboardSampleFormPage();

        Assert.assertTrue(homePage.validateAppLogo());
        Assert.assertTrue(homePage.validateMainNav());
        Assert.assertTrue(homePage.validateSideNav());
        Assert.assertTrue(homePage.validateEntryTitle("Home"));
    }

    @When("^title of login page is ToolsQA$")
    public void title_of_login_page_is_toolsqa() {
        String homePageTitle = homePage.validatePageTitle();
        Assert.assertEquals(homePageTitle, "ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation","error message - page title is not a match");
    }

    @Then("^user goes to  Keyboard Sample Form$")
    public void user_goes_to_keyboard_sample_form() {
        homePage.goTo("Keyboard Events Sample Form");
    }

    @Then("^user enters (.+), (.+), (.+) fillers$")
    public void user_enters_fillers(String userName, String currentAddress, String permanentAddress) {
        keyboardSampleFormPage.fillForm(userName, currentAddress, permanentAddress);
        driver.quit();
    }
}
