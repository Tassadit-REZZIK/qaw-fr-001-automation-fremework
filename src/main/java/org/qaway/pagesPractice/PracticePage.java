package org.qaway.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;
import org.testng.Assert;

public class PracticePage extends CommonAPI {
    public PracticePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath = "//input[@id='name']")
    WebElement alertField;

    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertBtb;

    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirmBtn;

//    String str = "1";
//    @FindBy(xpath = "//input[@name='checkBoxOption"+str+"']")
//    WebElement checkbox;


    @FindBy(xpath = "//input[@name='checkBoxOption1']")
    WebElement checkbox1;
    @FindBy(xpath = "//input[@name='checkBoxOption2']")
    WebElement checkbox2;
    @FindBy(xpath = "//input[@name='checkBoxOption2']")
    WebElement checkbox3;

    @FindBy(xpath = "//input[@id='displayed-text']")
    WebElement ElementDisplayedExample;

    @FindBy(xpath = "//input[@id='hide-textbox']")
    WebElement ElementBoxHide;



    public void click1(){
        type(alertField, "hanafi");
        clickOn(alertBtb);
    }
     public void click2(){
        clickOn(confirmBtn);
    }

    public void checkbox1(){
        clickOn(checkbox1);
        isSelected(checkbox1);
    }
    public void checkbox2(){
        clickOn(checkbox2);
        isSelected(checkbox2);
    }
    public void checkbox3(){
        clickOn(checkbox3);
        isSelected(checkbox3);
    }

    public void elementDisplayed(){
        isDisplayed(ElementDisplayedExample);
        Assert.assertTrue(isDisplayed(ElementDisplayedExample));
        System.out.println("element displayed example is displayed");
        clickOn(ElementBoxHide);
        System.out.println("click on hide is ok");
        isDisplayed(ElementDisplayedExample);
        Assert.assertFalse(isDisplayed(ElementDisplayedExample));
//        Assert.assertTrue(isDisplayed(ElementDisplayedExample));
        System.out.println("element displayed example is not displayed");
    }

    public boolean alertFieldIsDisplayed(){
        return isDisplayed(alertField);
    }

    public WebElement alertFieldElement(){
        return alertField;
    }

    public WebElement alertBtbElement(){

        return alertBtb;
    }

    public WebElement confirmBtnElement(){
        return confirmBtn;
    }

//    public boolean findElementIsDisplayed(){
//
//        return isDisplayed(findElement);
//    }

//    public boolean findElementTextIsDisplayed(){
//
//        return isDisplayed(findElementIsDisplayedText);
//    }







    public WebElement checkbox1Element(){
        return checkbox1;
    }

    public WebElement checkbox2Element(){
        return checkbox2;
    }

    public WebElement checkbox3Element(){
        return checkbox3;
    }

//    public WebElement findBoxElement(){
//        return findElementBox;
//    }

}
