package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

import java.util.List;

public class ButtonRadioPage extends CommonAPI {
    public ButtonRadioPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@type='radio']")
    List<WebElement> radioButtons;


    public List<WebElement> radio(){
        return radioButtons;
    }
}


