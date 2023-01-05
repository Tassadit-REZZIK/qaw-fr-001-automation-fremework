package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class SelectDropDownPage extends CommonAPI {
    public   SelectDropDownPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//select[@id='dropdown-class-example']")
    WebElement  dropdown;


    public void SelectOption1(){
        selectFromDropdown(dropdown, "Option1");
    }
    public void SelectOption2(){
        selectFromDropdown(dropdown, "Option2");
    }
    public void SelectOption3(){
        selectFromDropdown(dropdown, "Option3");
    }

//    Select select = new Select(dropdown);
//
//        select.selectByVisibleText("Option3");
//
//        Thread.sleep(3000);
//        driver.close();

}

