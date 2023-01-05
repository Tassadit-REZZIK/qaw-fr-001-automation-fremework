package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.ScrollDownPage;
import org.testng.annotations.Test;

public class TestScrollDown extends CommonAPI {

    @Test
    public void TestSD(){
        ScrollDownPage scrollDownPage = new ScrollDownPage(driver);
        scrollDownPage.scrolldown();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView();", scrollDownPage.smith());
    }
}
