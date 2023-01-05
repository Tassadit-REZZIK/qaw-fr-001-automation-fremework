package org.qaway.testsPractice;

import org.openqa.selenium.WebElement;
import org.qaway.base.CommonAPI;
import org.qaway.utility.Utility;
import org.qaway.pagesPractice.ButtonRadioPage;
import org.testng.annotations.Test;

import java.util.List;

public class TestButtonPage extends CommonAPI {

    @Test
    public void testButton(){
        ButtonRadioPage radioPage = new ButtonRadioPage(driver);
        List <WebElement> radio = radioPage.radio();
        Utility.radiobutton(radio, "radio1");
    }
}
