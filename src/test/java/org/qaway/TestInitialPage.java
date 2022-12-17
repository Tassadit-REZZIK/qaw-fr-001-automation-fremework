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
import org.qaway.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class TestInitialPage extends CommonAPI { // je rajoute extends CommonAPI
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
        String expected = "Swag Labs";
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("test pass");
    }
    @Test
    public void validateLoginPageElements(){
        String expected = "Swag Labs";
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation succes");

//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        boolean userNameIsDisplayed = usernameFiled.isDisplayed();
        boolean userNameIsDisplayed = isDisplayed("#user-name");
        Assert.assertTrue(userNameIsDisplayed);
        System.out.println("username field is displayed");

//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        boolean passwordIsDisplayed = isDisplayed("#password");
        Assert.assertTrue(passwordIsDisplayed);
        System.out.println("password field is displayed");

//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        boolean loginButtonIsDisplayed = isDisplayed("#login-button");

        Assert.assertTrue(loginButtonIsDisplayed);
        System.out.println("login button field is displayed");
    }


}







