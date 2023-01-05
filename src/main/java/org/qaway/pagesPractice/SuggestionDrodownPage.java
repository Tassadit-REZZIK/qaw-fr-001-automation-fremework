package org.qaway.pagesPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class SuggestionDrodownPage extends CommonAPI {

    public  SuggestionDrodownPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='autocomplete']")
    WebElement autocomplete;


    public void suggestiondrodown(){
        type(autocomplete, "can");
        typeKeys(autocomplete, (Keys.ARROW_DOWN));
        typeKeys(autocomplete, (Keys.ENTER));

    }
}
