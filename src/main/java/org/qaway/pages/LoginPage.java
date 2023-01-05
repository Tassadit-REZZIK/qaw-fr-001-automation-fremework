package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class LoginPage extends CommonAPI {

    // initialisation des elements
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);// on a plus besoin d'utiliser findElement
    }
    @FindBy(css="#user-name")
    //objects
//    WebElement userNameField = driver.findElement(By.cssSelector("#user-name"));// pour avoir accés au driver faut faire extend
    WebElement userNameField;
    //j'élémine driver.findElement dans comminAPI dans la methode type
    //WebElement userNameField = driver.findElement(By.xpath("#user-name"));// si c'est un xpath en créant une autre méthode pour userNameField
    //    WebElement passwordField = driver.findElement(By.cssSelector("#password"));
    @FindBy(css="#password")
    WebElement passwordField;
    @FindBy(css="#login-button")
//    WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));
    WebElement loginBtn;
    @FindBy(css=".error-message-container.error")
//    WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));// nouveau WebElement
    WebElement errorMessage;

    //reusable steps
//    public void typeUsername(){
//        type(userNameField,"");

    @FindBy(xpath = "//input[@id='name']")
    WebElement alertField;
    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertBtb;

    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirmBtn;



    public boolean usernameFieldIsDisplayed(){
//        LOG.info("username field displayed success");
        LOG.info("cheking username field is displayed ...");
        return isDisplayed(userNameField);
    }
    public void typeUsername(String username){ // on donne ici le username, il est générique ici car je vais appeler
        type(userNameField, username);

    // la méthode type userName car c'est une étape dans

//  userNameField.sendKeys(""); // je ne veux pas utiliser selenium ici, tout ce qui est selenium je le garde dans API
    }
    public boolean passwordFieldIsDisplayed(){
//        LOG.info("password field displayed success");
        LOG.info("cheking password field is displayed ...");
        return isDisplayed(passwordField);
    }
    public void typePassword(String password){
        type(passwordField, password);
    }
    public boolean loginBtnIsDisplayed(){
        LOG.info("cheking login button is displayed ...");
        return isDisplayed(loginBtn);
    }
    public void clickOnLoginButton(){
//        LOG.info("login button displayed success");
        clickOn(loginBtn); // c'est un WebElement alors qu'il attend un string, je change la méthode click dans CommonAPI
    }

    public String getErrorMessage(){
        return getWebElementText(errorMessage);
    }

    public void login(String username, String password){
        typeUsername(username);
//        System.out.println("username enter success");
        typePassword(password);
//        System.out.println("password enter success");
        clickOnLoginButton();
//        System.out.println("login button enter success");
        LOG.info("login process success");
//        System.out.println("login process success");
    }

}
