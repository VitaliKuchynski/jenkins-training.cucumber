package framework.hotels;


import framework.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

 //Assigns sign in menu link locator
private By menuSignhInAccountLink= By.xpath("//a[@id='hdr-account']");
//Assigns Sing in link locator  from menu
private By signInMenuLink=By.xpath(".//div[@id='menu-bar']/descendant::a[@id='hdr-signin']");
//Assigns email locator
private By emailField = By.xpath("//div[@class='form-field']/descendant::input[@id='sign-in-email']");
//Assigns password locator
private By passwordField = By.xpath("//div[@class='form-field']/descendant::input[@id='sign-in-password']");
//Assigns sign in button locator
private By signInButton = By.xpath(".//div[@class='form-actions']/descendant::button[@type='submit']");



    //Clicks on menu SignIn&Account link
    public void clickOnMenuSignInAccount(){
    clickOn(menuSignhInAccountLink);
}
    //Clicks on menu SignIn link in menu
    public void clickOnSignInLink(){
        clickOn(signInMenuLink);
    }
    //Sends keys to input field
    public void enterEmail(String email){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendText(emailField,email);
    }
    //Sends keys to password field
    public void enterPassword(String password){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendText(passwordField,password);
    }

    //Clicks on SignIn button
    public void clicksOnSignInButton(){
        clickOn(signInButton);
    }
}
