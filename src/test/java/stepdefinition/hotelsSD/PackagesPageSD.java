package stepdefinition.hotelsSD;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.hotels.HomePage;
import framework.hotels.PackagesPage;
import org.testng.Assert;

public class PackagesPageSD {
    //Instance of home page
    HomePage homePage = new HomePage();
    PackagesPage packagesPage = new PackagesPage();

    @Given("^I an on flight packages page$")
    public void iAmOnPackagesFlightPage() throws InterruptedException {
        homePage.clickOnPackagesLink();
        String expectedTitle = packagesPage.getTitlePackagesPage();
        String actualTitle = packagesPage.getActualTitleOfPackagesPage();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("^I click on Flight only tab$")
    public void clickOnFlightOnlyTab() {
        packagesPage.clickOnFlightOnlyTab();
    }

    @And("^I enter (.+) into (Flying from|Flying to) field$")
    public void selectFlyingAirports(String city, String airport) throws InterruptedException {
        switch (airport) {
            case "Flying from":
                packagesPage.enterFlightFromCity(city);
                break;
            case "Flying to":
                packagesPage.enterFlightToCity(city);
                break;
        }
    }

    @And("^I select (.+) and (.+) from (departure|returning) date$")
    public void selectTravelDates(String date, String month, String way) {
        switch (way) {
            case "departure":
                packagesPage.clickOnDepartureDatePicker();
                packagesPage.selectDate(month, date);
                break;
            case "returning":
                packagesPage.clickOnReturningDatePicker();
                packagesPage.selectDate(month, date);
                break;
        }
    }

    @And("^I select (\\d) adults passengers$")
    public void selectPassengers(String numbers) throws InterruptedException {
        packagesPage.selectAdultPassengers(numbers);
    }

    @And("^I click on (search|book now) button$")
    public void clickOnButton(String button) {
        switch (button) {
            case "search":
                packagesPage.clickOnSearchButton();
                break;
            case "book now":
                packagesPage.clickOnBookingNowButton();
                break;
        }
    }

    @And("^I select (departure|returning) nonstop trip$")
    public void clickOnNonStopCheckbox(String airport) {
        switch (airport) {
            case "departure":
                packagesPage.checkNonStopCheckBox();
                break;
            case "returning":
                packagesPage.checkNonStopCheckBox();
                break;
        }
    }

    @And("^I click on select button on first (departure|returning) flight$")
    public  void selectFlightFromList(String flight){
        switch (flight) {
            case "departure":
                packagesPage.selectFirstFlightFromList();
                break;
            case "returning":
                packagesPage.selectFirstFlightFromList();
                packagesPage.switchToBookingWindow();
                break;
        }
    }

    @And("^I click on  Roundtrip Fligh link$")
    public void clickOnRoundFlightLink(){
        packagesPage.clicksOnRoundTripFlight();
    }
    @Then("^I verify (number of stops|passengers) value$")
    public void verifyNumberOfStops(String value){
        switch (value) {
            case "number of stops":
        Assert.assertEquals(true,packagesPage.isActualExpectedTripStopsEqual());
                break;
            case "passengers":
                String actualResult =packagesPage.getActualAdultsPassengers();
                String expectedResult =packagesPage.getExpectedAdultsPassengers();
                Assert.assertEquals(actualResult,expectedResult);
                break;
        }
    }
    @And("^I verify (departure|returning) date$")
    public void verifyDates(String date){
        switch (date) {
            case "departure":
                System.out.println(packagesPage.getActualDepartureDate());
                break;
            case "returning":
                System.out.println(packagesPage.getActualReturningDate());
                break;
        }
    }
    @And("^I verify leaving and destination airports$")
    public void verifyLivingDestinationAirports(){
        Assert.assertEquals(packagesPage.getActualTripAirports().trim(),"New York (JFK) to San Diego (SAN)");

    }

    @And("^I check (.+) check box$")
    public void checkAirlinesCheckbox(String airline){
        packagesPage.checkAirlineCheckbox(airline);
    }
    @And("^I select (.+) from dropdown$")
    public void selectPriceValue(String value){
        packagesPage.selectValueFromSortList(value);
    }
    @Then("^I verify (airlines|price) is displayed correctly$")
    public void iVerifyAirlinesIsDisplayedCorrectly(String field) {
        switch (field) {
            case "airline":

                break;
            case "price":
    Assert.assertEquals(true,packagesPage.isPricesSortedCorrectly());
                break;
        }
    }



}