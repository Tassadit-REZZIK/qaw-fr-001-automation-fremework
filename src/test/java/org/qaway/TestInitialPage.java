package org.qaway;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import sun.jvm.hotspot.utilities.Assert;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class TestInitialPage extends CommonAPI { // je rajoute extends CommonAPI
    // on crée l'objet de excel reader et cella qu'on donne le constarctor (FilePath et SheetName) qu'on a crée dans la classe "ExcelReader"
    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());

    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

//    LoginPage loginPage = new LoginPage(driver); // il ne marche pas globalement, faut le mettre localement
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */

    //      @Test
//      public void testApp() {
//          Assert.assertTrue( true );
  
    @Test
    public void validateLandingPage() {
//        LoginPage loginPage = new LoginPage(driver);
//        String expected = "Swag Labs";
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
//        System.out.println("test pass");
        LOG.info("test pass");
    }
    @Test
    public void validateLoginPageElements(){
        LoginPage loginPage = new LoginPage(driver);
//        String expected = "Swag Labs";
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
//        System.out.println("page title validation succes");
        LOG.info("page title validation succes");
        captureScreenshot("initialpage");

//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        boolean userNameIsDisplayed = usernameFiled.isDisplayed();
//        boolean userNameIsDisplayed = isDisplayed("#user-name");
        boolean userNameIsDisplayed = loginPage.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
//        loginPage.usernameFieldIsDisplayed();
//        System.out.println("username field is displayed");
        LOG.info("username field is displayed");


//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        boolean passwordIsDisplayed = usernameFiled.isDisplayed();
//        boolean passwordIsDisplayed = isDisplayed("#password");
//        boolean usernameIsDisplayed = isDisplayed("#password");
        boolean passwordIsDisplayed = loginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("password field is displayed");
        LOG.info("password field is displayed");


//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
//        boolean loginButtonIsDisplayed = isDisplayed("#login-button");
        boolean loginButtonIsDisplayed = loginPage.loginBtnIsDisplayed();

        Assert.assertTrue(loginButtonIsDisplayed);
//        System.out.println("login button field is displayed");
        LOG.info("login button field is displayed");
    }


}







