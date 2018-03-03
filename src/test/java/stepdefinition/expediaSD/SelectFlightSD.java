package stepdefinition.expediaSD;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.expedia.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class SelectFlightSD {

    private HomePage homePage = new HomePage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
    }


    @When("^I click on (search) button on home screen$")
            public void clickOnButton(String button){
        homePage.clickOnSearchButton();
    }

    @Then("^I verify that i get an error messages$")
    public void getErrorMessage(){
        Assert.assertEquals(SharedSD.getDriver().findElement(By.xpath("//div[@class=\"alert alert-error  validation-alert\"]/descendant::h5")).getText(),"Please correct the errors below.");
    }



}
