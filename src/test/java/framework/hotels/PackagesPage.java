package framework.hotels;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static util.Sleep.pause;

public class PackagesPage extends BasePage{
    //Initialise variable and assigns expected title
    private String titlePackagesPage = "Vacation Packages: Find Cheap Trips, Deals & Vacations | Hotels.com";
    //Initialise variable and assigns flight only tap locator
    private By flightOnlyTab = By.xpath(".//div[@id='wizard-container']/descendant::a[@id='tab-flight-tab']");
    //Initialise variable and assigns Flight from field locator
    private By flightFromField = By.xpath("//input[@id='flight-origin']");
    //Initialise variable and assigns Flight to field locator
    private By flightToField = By.xpath("//input[@id='flight-destination']");
    //Initialise variable air ports suggestion
    private By autoSuggestionAirports = By.xpath(".//div[@class='display-group-results']/descendant::a");
    //Initialise variable and assigns departure date
    private By departureDatePiker= By.id("flight-departing");
    //Initialise variable and assigns returning date
    private By returningDatePiker= By.id("flight-returning");
    //Initialise variable and assigns two months days location
    private By currentNextMonthDates = By.xpath(".//div[@class='datepicker-cal-month']/descendant::td");
    //Initialise variable and assign first month in date picker
    private By monthDatePicker = By.xpath(".//div[@class='']/descendant::caption[position()=1]");//?????
    //Initialise variable and assigns one month days
    private By daysOfMonth = By.xpath(".//div[@class='']/descendant::tbody[position()=1]/tr/td");//?????
    //Initialise variable and assigns next departure month button
    private By nextDepartureMonthButton = By.xpath(".//div[@id='flight-departing-wrapper']/descendant::button[position()=3]");
    //Initialise variable and assigns next month button
    private By nextReturningMonthButton = By.xpath("//div[@id='flight-returning-wrapper']/descendant::button[position()=3]");
    //Initialise variable and assigns adult passengers dropdown options
    private By adultsPassengersDropdownOptions = By.xpath(".//select[@id='flight-adults']/descendant::option");
    private By adultPassengerDropDown= By.xpath("//*[@id='flight-adults']");
    //Initialise search button locator
    private By searchButton=By.id("search-button");
    //Initialise variable and assigns first select button from the list of searched flights
    private By firstSelectButton = By.xpath(".//div[@id='flight-listing-container']/descendant::button[position()=1]");
    //Initialise variable and assigns nonstop checkbox locator
    private By nonStopCheckBox= By.xpath("//input[@data-test-id='Nonstop']");
    //Initialise variable, assigns forcedChoiceNoThanks link locator
    private By forcedChoiceNoThanks = By.id("forcedChoiceNoThanks");
    //Initialise variable, assigns booking now button locator
    private By bookingNowButton = By.xpath("//*[@id='FlightUDPBookNowButton1']/button");
    //Initialise variable, assigns round trip link locator
    private By roundTripLink = By.xpath("//div[@class='product-content']//a[@role='button']");
    //Initialise variable, assigns actual number stops locator
    private By actualTripStops = By.xpath(".//div[@class='duration-stop-information']/descendant::span[position()=3]");
    //Initialise variable, assigns actual dates
    private By actualTripAirports =By.xpath("//div[@class='location-info']");
    //Initialise variable, assigns actual dates
    private By actualReturnDepartureDays= By.xpath(".//div[@class='flight-information']/descendant::span[position()=1]");
   //Initialise variable, assigns actual passengers value
    private By actualPassengerValue = By.xpath(".//div[@class='product-description']");
    //Initialise locator to airlines check box
    private By airlinesCheckboxes = By.xpath(".//fieldset[@id='airlines']/descendant::input");
    //Initialise variable and store sort-dropdown locator
    private By sortDropDown = By.name("sort");
    //Initialise variable, assigns sort dropdown options locators
    private By sortDropdownOptions = By.xpath(".//*[@name='sort']/descendant::option");
    //Initialise variable, assigns locator of airlines names
    private By actualAirlinesAfterSearch = By.xpath("//div[@id='flight-listing-container']/descendant::span[@data-test-id='airline-name']");
    //Initialise variable, assigns locator of prices
    private By actualPrices = By.xpath("//div[@id='flight-listing-container']/descendant::span[@data-test-id='listing-price-dollars']");
    //Stores checked airline
    private String expectedAirline;
     //Collections of actualDates
    private List<WebElement> actualDates;
    //Collection of prises after search
    private  ArrayList<Integer> pricesSortedInInt = new ArrayList<>();
    private  ArrayList<Double> pricesSortedInDoble = new ArrayList<>();
    //Collection of sorted Airlines on searching page
    private List<WebElement> sortedListOfAirlines;
    //Collection of options  from sorting dropdown
    private List<WebElement> listOfSortingOptions;
    public String actualDepartureMonth;
    public String actualDepartureDate;
    public String expectedStopsNumber;
    private String expectedAdultsPassengers;
    List <WebElement> listOfDays;

    //Gets passengers
    public String getExpectedAdultsPassengers() {
        return expectedAdultsPassengers;
    }

    //Getters for expected title
    public String getTitlePackagesPage() {
        return titlePackagesPage;
    }
    //Gets tittle from packages page
    public String getActualTitleOfPackagesPage(){
       return getTitle();
    }
    //Clicks on Flight only tab
    public void clickOnFlightOnlyTab(){
        clickOn(flightOnlyTab);
    }
    //Sends text to flight from airport
    public void enterFlightFromCity(String city) throws InterruptedException {
        sendText(flightFromField,city);
        //Gets list of suggested airports and assigns it to List collection
//        List<WebElement> listOfCityAirports =  findAndWaitOfWebElements(autoSuggestionAirports);//
//        Thread.sleep(3000);
//        autoComplete(listOfCityAirports,city);
    }
    //Sends text to flight to airport
    public void enterFlightToCity(String city) throws InterruptedException {
        sendText(flightToField,city);
        Thread.sleep(5000);
        //Gets list of suggested airports and assigns it to List collection
        List<WebElement> listOfArrivalsCityAborts =  findAndWaitOfWebElements(autoSuggestionAirports);
        autoComplete(listOfArrivalsCityAborts,city);
    }
    //Clicks on returning date input field
    public void clickOnReturningDatePicker(){
        clickOn(returningDatePiker);
    }
    //Clicks on departure date input field
    public void clickOnDepartureDatePicker(){
        clickOn(departureDatePiker);
    }
    //Sets list of the days
    public void setListsOfDays(){
         listOfDays = findAndWaitOfWebElements(currentNextMonthDates);
    }
    //Selects date from flight from / to
    public void selectDepartureDate(String month, String expectedDate){
        actualDepartureMonth = month.substring(0,3);
        actualDepartureDate = expectedDate;
        String result= actualDepartureMonth + " " +actualDepartureDate;
        System.out.println(result);
        String firstMonth = findAndWaitOfWebElement(monthDatePicker).getText().trim();
        try{
        while(!firstMonth.equalsIgnoreCase(month)){
            clickOn(nextDepartureMonthButton);
            firstMonth = findAndWaitOfWebElement(monthDatePicker).getText().trim();
        }
            if (firstMonth.equalsIgnoreCase(month)) {
                List<WebElement> listOfDays= findAndWaitOfWebElements(daysOfMonth);
                for (WebElement list : listOfDays) {
                    if (list.getText().equalsIgnoreCase(expectedDate)) {
                        list.click();
                        break;
                    }
                }

            }
        }catch (Exception ex){
            ex.getMessage();
            System.out.println("Dates should be changed!!");
        }
    }
    public void selectReturningDate(String month, String expectedDate){
        actualDepartureMonth = month.substring(0,3);
        actualDepartureDate = expectedDate;
        String result= actualDepartureMonth + " " +actualDepartureDate;
        System.out.println(result);
        String firstMonth = findAndWaitOfWebElement(monthDatePicker).getText().trim();
        try{
        while(!firstMonth.equalsIgnoreCase(month)){
            clickOn(nextReturningMonthButton);
            firstMonth = findAndWaitOfWebElement(monthDatePicker).getText().trim();
        }
        if (firstMonth.equalsIgnoreCase(month)) {
            List<WebElement> listOfDays= findAndWaitOfWebElements(daysOfMonth);
            for (WebElement list : listOfDays) {
                if (list.getText().equalsIgnoreCase(expectedDate)) {
                    list.click();
                    break;
                }
            }
        }
        }catch (Exception ex){
            ex.getMessage();
            System.out.println("Dates should be changed!!");
        }
    }
    //Clicks on search button
    public void clickOnAdultPassengerDropDown(){
        clickOn(adultPassengerDropDown);
    }
     // Selects number of adults passengers
    public void selectAdultPassengers(String number) {
        expectedAdultsPassengers = number+ " " + "adults";
        clickOnAdultPassengerDropDown();
       List<WebElement> adultsValue = findAndWaitOfWebElements(adultsPassengersDropdownOptions);
       selectOnElementFromList(adultsValue,number);
        }

        //clicks on search button
    public void clickOnSearchButton(){
        clickOn(searchButton);
    }
    //Checks on nonStopCheckBox
    public void checkNonStopCheckBox() {
       // waitUntilElementClickable(nonStopCheckBox,40);
       pageLoadingWait(40);
        clickOn(nonStopCheckBox);
        try {
            expectedStopsNumber = findAndWaitOfWebElement(nonStopCheckBox).getAttribute("data-test-id");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Selects first flights
    public void selectFirstFlightFromList(){
        waitUntilElementClickable(firstSelectButton,40);
        clickOn(firstSelectButton);
    }
//    public void clickOnNoThanksLink(){
//        clickOn(forcedChoiceNoThanks);
//    }
    //Clicks on booking now button
    public void clickOnBookingNowButton(){
        clickOn(bookingNowButton);
    }
    //Switch to booking window
    public void switchToBookingWindow(){
        switchToWindow(1);
    }
    //Clicks on round trip link
    public void clicksOnRoundTripFlight(){
        clickOn(roundTripLink);
    }
    //Gets text number of stops
    public boolean isActualExpectedTripStopsEqual(){
        return getTextFromElement(actualTripStops).equalsIgnoreCase(expectedStopsNumber);
    }
    //Gets and returns actual Departure  date
    public String getActualDepartureDate(){
        actualDates = findAndWaitOfWebElements(actualReturnDepartureDays);
        return actualDates.get(0).getText().substring(5);

    }
    //Gets and returns actual Returning date
    public String getActualReturningDate(){
        return actualDates.get(1).getText().substring(5);
    }
    //Gets and returns actual Returning date
    public String getActualTripAirports(){
        return getTextFromElement(actualTripAirports);
    }
    //Gets and returns actual Returning date
    public String getActualAdultsPassengers(){
        return getTextFromElement(actualPassengerValue).substring(11);
    }
    //Checks airlines check box
    public void checkAirlineCheckbox(String airline){
        this.expectedAirline = airline;
        waitUntilElementClickable(airlinesCheckboxes,40);
        List<WebElement> listOfAirlinesCheckboxes = findAndWaitOfWebElements(airlinesCheckboxes);
        for(WebElement ele: listOfAirlinesCheckboxes){
            System.out.println(ele.getAttribute("data-test-id"));
            if(ele.getAttribute("data-test-id").equalsIgnoreCase(airline)){
                ele.click();
               pause(5000);
                break;
            }
        }
        sortedListOfAirlines = findAndWaitOfWebElements(actualAirlinesAfterSearch);
    }
    //Clicks on Sort dropdown on search page
    public void clickOnSortDropDown(){
        clickOn(sortDropDown);
    }
    //Selects value from sorting dropdown
    public void selectValueFromSortList(String value){
        clickOnSortDropDown();
        listOfSortingOptions = findAndWaitOfWebElements(sortDropdownOptions);
        pause(5000);
        selectOnElementFromList(listOfSortingOptions,value);
    }
    //Gets price in String convert to int
     public void formatPriceStringToInt() {
         List<WebElement> listOfPrices = findAndWaitOfWebElements(actualPrices);
         for (WebElement ele : listOfPrices) {
             pricesSortedInInt.add(Integer.parseInt(ele.getText().substring(1)));
             //parses string to double
             pricesSortedInDoble.add(Double.parseDouble(ele.getText().substring(1)));
         }

    }
    //Compares that highest prise is first NEED TO BE REDEVELOPED
    public boolean isPricesSortedCorrectly() {
        formatPriceStringToInt();
     if(pricesSortedInInt.get(0)>=pricesSortedInInt.get(1)){
         return true;
     }  else {
         return false;
        }
    }
    public boolean isAirlinesDisplayCorrectly(){
        return isElementInTheList(sortedListOfAirlines,expectedAirline);

    }

}


