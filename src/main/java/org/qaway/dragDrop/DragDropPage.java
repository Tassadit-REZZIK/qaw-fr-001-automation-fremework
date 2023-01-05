package org.qaway.dragDrop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class DragDropPage extends CommonAPI {
    public DragDropPage(WebDriver driver){PageFactory.initElements(driver, this);}


    @FindBy(xpath = "//div[@id='draggable']")
    WebElement draggable;

    @FindBy(xpath = "//div[@id='droppable']")
    WebElement droppable;

    @FindBy(xpath = "//a[normalize-space()='Demos']")
    WebElement Demo;


    public WebElement draggableElement(){
        return draggable;
    }

    public WebElement  droppableElement(){
        return  droppable;
    }

    public void clickDemo(){
        clickOn(Demo);
    }



}
