package stepdefinition.amazonSD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.amazon.HomePage;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class DepartmentsSD {

    HomePage homePage = new HomePage();


    @Given("^I am on Amazon home page$")
    public void imOnHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @When("I mouse over department drop-down")
    public void hoverOverDepartmentsList() throws InterruptedException {
        homePage.mouseoverToDepartmentsMenu();

   }

   @Then("^I verify that department (.+) in the list$")
    public void listOfDepartments(String name){
         Assert.assertEquals(homePage.navigateThroughListOfDepartment(name),true);
   }

}
