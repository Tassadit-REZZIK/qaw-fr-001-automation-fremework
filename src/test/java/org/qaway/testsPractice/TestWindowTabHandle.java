package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.WindowTabHandlePage;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestWindowTabHandle extends CommonAPI {

    @Test
    public void windowTabHandle(){
        WindowTabHandlePage  windowTabHandlePage = new WindowTabHandlePage(driver);
        windowTabHandlePage.clicktab();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String tab = it.next();
        driver.switchTo().window(tab);
        System.out.println("switch to tab success");
        windowTabHandlePage.clicklogin();

    }
}
