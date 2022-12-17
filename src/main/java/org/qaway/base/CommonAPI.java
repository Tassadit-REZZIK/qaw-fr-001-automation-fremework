package org.qaway.base;

//import org.junit.After;
//import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

    public WebDriver driver;   // l'enlever localement et le mettre globalement
                               // mettre driver public
    @BeforeMethod // une notation qui vient de junit; on a pas besoin d'appeler setUp();
    public void setUp(){
        // WebDriver driver;  // créer cette instance 'selenium'
        // l'enlever localement et le mettre globalement
        //System.setProperty("driver.chromedriver","driver.ChromeDriver\",\"C:\\Users\\rezzi\\IdeaProjects\\qaw-fr-001-automation\\driver\\chromedriver");
        //responsable du réglage du pilote, automatiquement selenium me télécharge le pilote du browser que je veux utiliser
        // j'indique à driver ou est le fichier(pilote) 'java'
        driver = new ChromeDriver();
        // je veux acceder à sauce demo.com
        driver.manage().window().maximize(); // pour maximiser le browser
        driver.get("https://www.saucedemo.com");
        System.out.println("browser open success"); // ne fait pas partie du test plutot du setup
    }
    @AfterMethod // une notation qui vient de junit; on a pas besoin d'appeler close();
    public void close(){
        driver.close();
        System.out.println("browser close success");
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    // pour puivoir importer les classes befor et after je dois aller dans pox.xml et effacer <scope>


    public void clickOn(String locator){  // on crée une méthode générique
        try {
            driver.findElement(By.cssSelector(locator)).click();
        }catch(Exception e){
            driver.findElement(By.xpath(locator)).click();
        }
    }

    public void type(String locator, String text){  // on crée une méthode générique
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        }catch(Exception e){
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public boolean isDisplayed(String locator){  // on crée une méthode générique
                                                 // isDisplayed faut qu'il me récupère un boolean
        try {
            return driver.findElement(By.cssSelector(locator)).isDisplayed();
        }catch(Exception e){
            return driver.findElement(By.xpath(locator)).isDisplayed();
        }
    }

    public String getWebElementText(String locator){
        try {
            return driver.findElement(By.cssSelector(locator)).getText();
        }catch(Exception e){
            return driver.findElement(By.xpath(locator)).getText();
        }
    }

//    public void waitFor(int sec) throws InterruptedException {
//        Thread.sleep(sec*1000);
//    }

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


// le but c'est de ne pas utiliser aucune instance de driver
}



