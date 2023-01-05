package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.SuggestionDrodownPage;
import org.testng.annotations.Test;

public class TestSuggestionDrodown extends CommonAPI {

    @Test
    public void testSuggestionDrodown() throws InterruptedException {
        SuggestionDrodownPage suggestion = new SuggestionDrodownPage(driver);
        suggestion.suggestiondrodown();
        Thread.sleep(2000);
    }
}
