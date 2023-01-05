package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFilter extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestFilter.class.getName());

    // tant que j'ai rajouté decod dans Utility, je dois décoder mes coordonées

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));


    // je fais appel à config.properties

//    String username = prop.getProperty("username");
//    String password = prop.getProperty("password");

    @Test
    public void filterFromLowToHigh(){
        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(username, password);
        Assert.assertTrue(homePage.productsHeaderIsDisplayed()); // Assert c'est une partie du test
        captureScreenshot("homepage");


        homePage.selectLowerToHigherFromFilter();   // spécifique
        System.out.println("list of prices:" +homePage.getItemsPrice());
//        homePage.selectFromFilter("Price (low to high)"); // générique
//        List<Double> prices = homePage.getItemsPrice();

        double[] finalPrices = Utility.listToArrayOfDouble(homePage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices)); // vérifier si la liste is sorted
        System.out.println("items sorted success");



    }
}
