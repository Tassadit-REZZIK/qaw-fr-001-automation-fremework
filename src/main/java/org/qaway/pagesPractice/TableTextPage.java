package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class TableTextPage extends CommonAPI {
    public   TableTextPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//table[@id='product']/tbody/tr[4]/td[2])[1]")
    WebElement product;

    public String textPage(){
        return getWebElementText(product);
    }
}
