package org.qaway;

//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.qaway.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends CommonAPI { // je rajoute extends CommonAPI

    // on va créer un autre test
    @Test
    public void loginWithValidCredential() {    //j'élimine "throws InterruptedException"
        // check user land and the right page
        String expected = "Swag Labs";
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        type("#user-name", "standard_user");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
        type("#password", "secret_sauce");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
        System.out.println("enter password success");
//        Thread.sleep(3000);
//        waitFor(3);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        clickOn("#login-button");
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        System.out.println("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement productsHeader = driver.findElement(By.cssSelector(".title")); // on récupere le css selector
//        boolean productsHeaderIsDisplayed = productsHeader.isDisplayed();
        boolean productsHeaderIsDisplayed = isDisplayed(".title");
        Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
        System.out.println("Products header is displayed success");
//        Thread.sleep(3000);
//        waitFor(3);
    }


    @Test
    public void loginAttemptWithoutUsername() throws InterruptedException {
        // check user land and the right page
        String expected = "Swag Labs";
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);


        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        type("#user-name", "");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
        type("#password", "secret_sauce");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);
//        waitFor(3);

//        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("");// envoyer une certaine formation
//        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
//        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindé ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//
//        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
//        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
//        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        clickOn("#login-button");
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        System.out.println("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container.error")); // on récupere le css selector
        // boolean productsHeaderIsDisplayed = productsHeader.isDisplayed(); // il ne s'agit pas de vérifier
//        String textError = errorAlert.getText();// je mets le text dans un string
        String textError = getWebElementText(".error-message-container.error");
                System.out.println("error message: "+ textError);
        Assert.assertEquals("Epic sadface: Username is required",textError);
        System.out.println("error message validation succes");
        //Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
//        Thread.sleep(3000);
//        waitFor(3);
    }

    @Test
    public void  loginAttemptWithoutPssword() throws InterruptedException {
        // check user land and the right page
        String expected = "Swag Labs";
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        type("#user-name", "standard_user");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);
        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
        type("#password", "");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//
//        waitFor(3);
//        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
//        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
//        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindé ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//
//        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("");
//        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
//        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        clickOn("#login-button");
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        System.out.println("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container.error")); // on récupere le css selector
        // boolean productsHeaderIsDisplayed = productsHeader.isDisplayed(); // il ne s'agit pas de vérifier
//        String textError = errorAlert.getText();// je mets le text dans un string
        String textError = getWebElementText(".error-message-container.error");
        System.out.println("error message: "+ textError);
        Assert.assertEquals("Epic sadface: Password is required",textError);
        System.out.println("error message validation succes");
        //Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
//        Thread.sleep(3000);
//        waitFor(3);
    }
}