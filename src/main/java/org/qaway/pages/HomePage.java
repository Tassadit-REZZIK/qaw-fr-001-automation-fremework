package org.qaway.pages;

/*import org.openqa.selenium.By;*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    // je crée un objet pour log4j
    Logger LOG = LogManager.getLogger(HomePage.class.getName()); // à partir du moment où on rajoute log4j à mon projet
    // on utilise plus le system.out.println

    // on crée un constracteur pour que ça marche
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    } // on a remplacé HomePage.class par this car le fait de pointer à HomePage une deuxième fois, probablement
    // il a crée une sorte de boucle qui essaye de lowder les élèments plusieurs fois
    // page object model and page factory

    @FindBy(css=".title")
//    WebElement productsHeader = driver.findElement(By.cssSelector(".title"));
    WebElement productsHeader;

    @FindBy(css=".product_sort_container")
    WebElement filterDropdown; // menu des roulants

    @FindBy(xpath="//div[@class='inventory_item_price']")
    List<WebElement> itemsPrice; // on a utilisé List car ça correspond à 6WebElemets

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement hamburgerMenu;

   @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement aboutLink;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement allItemsLink;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement resetAppStateLink;

    @FindBy(xpath = "(//div[@class='inventory_item_price']/following-sibling::button)[1]")
    WebElement item1;






    public boolean productsHeaderIsDisplayed(){
        LOG.info("products header is displayed");
//        System.out.println("products header is displayed");
        return  isDisplayed(productsHeader);
    }

    public void selectLowerToHigherFromFilter(){
        selectFromDropdown(filterDropdown, "Price (low to high)"); // cella est figée
        LOG.info("price low to high select success");
//        System.out.println("price low to high select success");
    }

    public void selectFromFilter(String option){
        selectFromDropdown(filterDropdown, option); // on peut séléctionner l'option qu'on veut plus tard
        LOG.info(option + " price low to high select success");
//        System.out.println(option + " price low to high select success");
    }

//    public List<String> getItemsPrice(){
//        List<String> prices = new ArrayList<String>();

    public List<String> getItemsPrice(){
        List<String> prices = new ArrayList<String>();
        for (WebElement itemPrice: itemsPrice){
//            prices.add(itemPrice.getText());
//            prices.add(itemPrice.getText().replace("$",""));
            prices.add(itemPrice.getText().replace("$",""));
        }
        return prices;
    }

    //
    public boolean validateAllItemsOptionIsDisplayed(){
//        boolean flag = isDisplayed (allItemsLink);
//        LOG.info("all items link display success");
//        System.out.println("all items link display success");
//        return flag;
        LOG.info("cheking all items link is displayed ...");
        return isDisplayed (allItemsLink);
    }
    public boolean validateAboutOptionsIsDisplayed(){
//        boolean flag = isDisplayed (aboutLink);
//        LOG.info("about link display success");
//        System.out.println("about link display success");
//        return flag;
        LOG.info("cheking about link is displayed ...");
        return isDisplayed (aboutLink);
    }
    public boolean validateLogoutOptionsIsDisplayed(){
//        boolean flag = isDisplayed (logoutLink);
//        LOG.info("logout link display success");
//        System.out.println("logout link display success");
//        return flag;
        LOG.info("cheking logout link is displayed ...");
        return isDisplayed (logoutLink);
    }
    public boolean validateResetAppStateOptionsIsDisplayed(){
//        boolean flag = isDisplayed (resetAppStateLink);
//        LOG.info("reset app state link display success");
//        System.out.println("reset app state link display success");
//        return flag;
        LOG.info("cheking app state link is displayed ...");
        return isDisplayed (resetAppStateLink);
    }

    public void clickOnHamburgerMenu (){
        clickOn(hamburgerMenu);
        LOG.info("click on hamburger menu success");
//        System.out.println("click on hamburger menu success");
    }
    public void clickAboutLink (){
        clickOn(aboutLink);
        LOG.info("click on about link success");
//        System.out.println("click on about link success");
    }
    public void addItem1ToCart(){
        clickOn(item1);
    }

    public String getItem1Color(){
        return getElementCssValue(item1);
    }
}
