package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class WindowTabHandlePage extends CommonAPI {
    public   WindowTabHandlePage  (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='opentab']")
    WebElement openTable;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login;

    public void clicktab(){
        clickOn(openTable);
    }

    public void clicklogin(){
        clickOn(login);
    }


}

