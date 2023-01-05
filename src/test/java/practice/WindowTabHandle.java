package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowTabHandle {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//a[@id='opentab']")).click(); // pour ouvrir le deuxième anglet
        // set elle n'accepte pas la duplication
        Set<String> windows = driver.getWindowHandles(); // récupérer le parent(les pages qui sont ouvertes au moment ou je travaille)
        Iterator<String> it = windows.iterator(); // iteartor une classe qui englobe les itérator

        String parent = it.next(); // correpond au parent
        String tab = it.next(); // correspond à l'autre table
        // on a englobé les 2 pages

        driver.switchTo().window(tab); // j'ai dit à windows si y'a un autre  dedans switch à celui d'après
        System.out.println("switch to tab success");

        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(3000);

//        driver.quit();

    }
}