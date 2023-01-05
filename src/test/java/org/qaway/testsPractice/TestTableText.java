package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.TableTextPage;
import org.testng.annotations.Test;

public class TestTableText extends CommonAPI {

    @Test
    public void tableText(){
        TableTextPage tabletextpage = new TableTextPage(driver);
        System.out.println(tabletextpage.textPage());

    }
}
