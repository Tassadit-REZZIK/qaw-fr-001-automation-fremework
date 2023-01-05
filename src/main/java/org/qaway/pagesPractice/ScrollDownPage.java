package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class ScrollDownPage extends CommonAPI {
    public  ScrollDownPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//td[normalize-space()='Smith']")
    WebElement Smith;

    public WebElement smith(){
        return Smith;
    }

    public void scrolldown(){
        scrollIntoView(driver, Smith);
    }
}


