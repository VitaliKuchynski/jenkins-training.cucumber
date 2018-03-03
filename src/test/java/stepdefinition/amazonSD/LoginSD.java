package stepdefinition.amazonSD;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.amazon.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class LoginSD {

    HomePage homePage = new HomePage();

    @Given("^I am on home page of Amazon$")
    public void imOnHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @When("^I Hover over to Accounts & List$")
    public void hoverOver() throws InterruptedException {
        homePage.mouseoverToAccountList();

    }

    @And("^I click on (Sign in|Default Sign in|continue|Account & Lists) button$")
    public void clickOnSignInButton(String button) {
        switch (button) {
            case "Sign in":
                homePage.clickOnSignInButton();
                break;
            case "continue":
                //Implement Create account object
                homePage.clickONContinueButton();
                break;
            case "Default Sign in":
                //Implement Create account object
                homePage.clickOnDefaultSignInButton();
                break;
            case "Account & Lists":
                //Implement Create account object
                homePage.clickOnAccountsListLink();
                break;
        }
    }

    @And("^I enter invalid (.+) into (email) address")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "email":
                homePage.enterEmail(anyText);
                break;
        }
    }

    @Then("^I verify (empty) error message$")
    public void verifyEmptyErrorMessage(String error) throws InterruptedException {
        switch(error){
//            case "invalid":
//            String actualMessage = SharedSD.getDriver().findElement(By.xpath(".//div[@class=\"a-alert-content\"]/descendant::span[@class='a-list-item']")).getText();
//            Assert.assertEquals(actualMessage, "We cannot find an account with that email address");
            case"empty":
            String actualEmptyMessage = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText();
            Assert.assertEquals(actualEmptyMessage,"Enter your email or mobile phone number");
    }
    }

    @Then("^I verify (invalid) error message$")
    public void verifyErrorMessage(String error) throws InterruptedException {
            String actualMessage = SharedSD.getDriver().findElement(By.xpath(".//div[@class=\"a-alert-content\"]/descendant::span[@class='a-list-item']")).getText();
            Assert.assertEquals(actualMessage, "We cannot find an account with that email address");
}

    @Then("^I verify password field appears$")
    public void verifyPasswordFieldAppears(){
        String actualField = SharedSD.getDriver().findElement(By.xpath("//label[@for='ap_password']")).getText();
        Assert.assertEquals(actualField,"Password");
    }


}