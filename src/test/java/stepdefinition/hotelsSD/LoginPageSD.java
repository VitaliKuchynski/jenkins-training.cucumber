package stepdefinition.hotelsSD;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.hotels.HomePage;
import framework.hotels.LoginPage;
import org.testng.Assert;


public class LoginPageSD {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("^I am on Hotels home page for sign in$")
    public void iAmOnHotelsHomePage() {
        Assert.assertEquals(homePage.getActualTitleHotelsHome(),homePage.getExpectedTitleHomePage());
    }

    @When("^I enter incorrect (.+) into Email address field$")
    public void iEnterCorrectCorrectEmail(String email) {
        loginPage.clickOnMenuSignInAccount();
        loginPage.clickOnSignInLink();
        loginPage.enterEmail(email);
    }

    @And("^I enter incorrect (.+) into password field$")
    public void iEnterCorrectPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("^I click on Sign-in button$")
    public void iClickOnSignInButton() {
        loginPage.clickOnSignInLink();
    }

    @Then("^I verify error message$")
    public void iVerifyErrorMessage() {
    }
}
