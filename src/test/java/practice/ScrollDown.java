package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollDown {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement element = driver.findElement(By.xpath("//td[normalize-space()='Smith']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; // élément de sélénium, on veut le castrer, le script que je veux faire
        js.executeScript("arguments[0].scrollIntoView();", element); // je crée l'élément que je veux
        // avec js.executeScript je fais ce que je veux, cliquer, récupérer..etc
        // scrollIntoVien pour scroller vers le bas

        Thread.sleep(3000);

        driver.close();

    }
}