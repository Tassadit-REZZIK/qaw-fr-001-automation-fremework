package org.qaway.testDragDrp;

import org.openqa.selenium.interactions.Actions;
import org.qaway.base.CommonAPI;
import org.qaway.dragDrop.DragDropPage;
import org.testng.annotations.Test;

public class TestDragDrop extends CommonAPI {

    @Test
    public void DragDropFrame() throws InterruptedException {
        DragDropPage dragDropPage = new DragDropPage(driver);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragDropPage.draggableElement(),dragDropPage.droppableElement()).build().perform();
        driver.switchTo().frame(0);
        System.out.println("switch to frame success");
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        System.out.println("switch to parent frame success");
        Thread.sleep(3000);
        dragDropPage.clickDemo();
    }

}
