package org.qaway.testsPractice;

import org.qaway.base.CommonAPI;
import org.qaway.pagesPractice.PracticePage;
import org.testng.annotations.Test;

public class TestPracticePage extends CommonAPI {
   @Test
   public void testAlert() {
       PracticePage practicePage = new PracticePage(driver);
       practicePage.click1();
//       System.out.println(driver.switchTo().alert().getText());
//       driver.switchTo().alert().accept();
       acceptAlert(driver);
       practicePage.click2();
//       System.out.println(driver.switchTo().alert().getText());
       System.out.println(getAlertText(driver));
//       driver.switchTo().alert().dismiss();
       getAlertDismiss(driver);
//       practicePage.alertFieldElement().sendKeys("hanafi");
//       Assert.assertTrue(practicePage.alertFieldIsDisplayed());
//       System.out.println("alert field is displayed");
//       practicePage.alertBtbElement().click();
//       System.out.println(driver.switchTo().alert().getText());
//       driver.switchTo().alert().accept();
//       practicePage.confirmBtnElement().click();
//       System.out.println(driver.switchTo().alert().getText());
//       driver.switchTo().alert().dismiss();
   }


   @Test
   public void checkBoxes() {
       PracticePage practicePage = new PracticePage(driver);
       practicePage.checkbox1();
       practicePage.checkbox2();
       practicePage.checkbox3();

   }
   @Test void elementDisplayed(){
       PracticePage practicePage = new PracticePage(driver);
       practicePage.elementDisplayed();
   }
//       practicePage.checkbox1Element().click();
//       System.out.println("click1 is ok");
//       practicePage.checkbox1Element().isSelected();
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       practicePage.checkbox2Element().click();
//       System.out.println("click2 is ok");
//       practicePage.checkbox2Element().isSelected();
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       practicePage.checkbox3Element().click();
//       System.out.println("click3 is ok");
//       practicePage.checkbox3Element().isSelected();




//    Assert.assertTrue(practicePage.findElementIsDisplayed());
//    System.out.println("find element is displayed");
//
//       practicePage.findBoxElement().click();

//       Assert.assertTrue(practicePage.findElementTextIsDisplayed());
//       System.out.println("find element text is displayed");
}




