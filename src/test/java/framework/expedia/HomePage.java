package framework.expedia;

import framework.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

private By searchButton = By.id("search-button-hp-package");


//Clicks on search button
public  void clickOnSearchButton(){
    clickOn(searchButton);

}

}
