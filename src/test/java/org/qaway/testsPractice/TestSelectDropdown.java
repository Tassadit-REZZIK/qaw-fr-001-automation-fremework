package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.SelectDropDownPage;
import org.testng.annotations.Test;

public class TestSelectDropdown extends CommonAPI {
//    static WebDriver dropdown;

    @Test
    public void SelectDropdown() throws InterruptedException {
       SelectDropDownPage selectdropdown = new SelectDropDownPage(driver);
       selectdropdown.SelectOption1();
       selectdropdown.SelectOption2();
       selectdropdown.SelectOption3();


    }
}
