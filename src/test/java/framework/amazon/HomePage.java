package framework.amazon;


import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.List;

public class HomePage extends BasePage {

    private By accountsListLink = By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]");
    private By sighInButton = By.xpath("//*[@id=\"nav-flyout-ya-signin\"]");
    private By defaultSighInButton = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");
    private By emailTextField = By.xpath("//*[@id=\"ap_email\"]");
    private  By continueButton = By.id("continue");
    private List <WebElement> departmentsList;
    private By departmentsLink = By.id("nav-link-shopall");

    public void mouseoverToAccountList() throws InterruptedException {
        mouseOverElement(accountsListLink);
    }
    public void mouseoverToDepartmentsMenu() throws InterruptedException {
        mouseOverElement(departmentsLink);
    }

public boolean navigateThroughListOfDepartment(String title){
    departmentsList = SharedSD.getDriver().findElements(By.xpath(".//div[@class=\"nav-template nav-flyout-content nav-tpl-itemList\"]/descendant::span[@class=\"nav-text\"]"));
    return isElementInTheList(departmentsList,title);
}
    public void clickOnSignInButton(){
        clickOn(sighInButton);
    }

    public void clickOnDefaultSignInButton(){
        clickOn(defaultSighInButton);
    }
    public void clickOnAccountsListLink(){
        clickOn(accountsListLink);
    }
    public void enterEmail(String enterEmail) {
        inputValue(emailTextField, enterEmail);
    }

    public  void clickONContinueButton(){
        clickOn(continueButton);
    }

}
