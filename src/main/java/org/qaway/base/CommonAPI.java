package org.qaway.base;

//import org.junit.After;
//import org.junit.Before;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaway.reporting.ExtentManager;
import org.qaway.reporting.ExtentTestManager;
import org.qaway.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CommonAPI {

    static Logger LOG = LogManager.getLogger(CommonAPI.class.getName());


    public WebDriver driver;   // l'enlever localement et le mettre globalement
                               // mettre driver public

    public Properties prop = Utility.loadProperties();
    String username = prop.getProperty("bs.username"); // soft coding
    String password = prop.getProperty("bs.password");

    String implicitWait = prop.getProperty("implicit.wait", "10");

    String takeScreenshot = prop.getProperty("take.screenshot", "false");

    String windowMaximaze = prop.getProperty("windowMaximaze", "true");




    //extend report: 39 - 97
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (takeScreenshot.equalsIgnoreCase("true")){
            LOG.info("take screenshot for failure true");
            if (result.getStatus() == ITestResult.FAILURE) {
                LOG.info("test failed");
                takeScreenshot(result.getName());
                LOG.info("take screenshot");
            }
        }
        driver.quit();
        LOG.info("browser close success");
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


//    @AfterMethod
//    public void close(){
//        driver.quit();
//        LOG.info("browser close success");
//    }



//     je crée une fonction pour faire marcher tout le travail ou soit sur mac, chrome, firefox..etc
//    public WebDriver getDriver(String os, String browserName){
//        if(os.equalsIgnoreCase("OS X")){  // dans chaque opérator system on peut avoir plusieurs browsers
//            if (browserName.equalsIgnoreCase("chrome")){
////            System.setProperty("driver.chromedriver", "../drivers/mac/chromedriver"); // dans le cas de nouvelle vérsion de sélénium 4, on a pas besoin de ces lignes
//            driver = new ChromeDriver();
//            } else if (browserName.equalsIgnoreCase("firefox")) {
////            System.setProperty("driver.geckodriver", "../drivers/mac/geckodriver");
//            driver = new FirefoxDriver();
//            }
//        } else if (os.equalsIgnoreCase("windows")) {
//            if (browserName.equalsIgnoreCase("chrome")){
////            System.setProperty("driver.chromedriver", "..\\driver\\win\\chromedriver.exe");
//            driver = new ChromeDriver();
//            } else if (browserName.equalsIgnoreCase("firefox")) {
////            System.setProperty("driver.geckodriver", "..\\drivers\\win\\geckodriver.exe");
//            driver = new FirefoxDriver();
//           }
//        } else if (os.equalsIgnoreCase("linux")) {
//            if (browserName.equalsIgnoreCase("chrome")){
////            System.setProperty("driver.chromedriver", "../drivers/mac/chromedriver");
//            driver = new ChromeDriver();
//            } else if (browserName.equalsIgnoreCase("firefox")) {
////            System.setProperty("driver.geckodriver", "../drivers/mac/geckodriver");
//            driver = new FirefoxDriver();
//            }
//        }
//        return driver;
//    }

//    public WebDriver getDriver(String browserName){
public void getDriver(String browserName){
        // les deux lignes qui suivent c'est pour exécuter en arrière plan
//            ChromeOptions options = new ChromeOptions();
//            options.setHeadless(false);
            if (browserName.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
//                driver = new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
    }

     //pour pouvoir tester mon travail dans "browsestack"

//    public WebDriver getCLoudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
public void getCLoudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        // 4 capability dans saucelab et browserstack
        cap.setCapability("os", os); // operator system
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1024x768"); // special browserstack
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),cap); // nom du lien, ceci pour browser stack
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd/hub"),cap); // pour browser stack et pour saucelab
        }
//        return driver;
    }




    @Parameters({"useCloudEnv","envName","url","os","osVersion","browserName","browserVersion"}) // vient du testNG
    @BeforeMethod // une notation qui vient de junit; on a pas besoin d'appeler setUp();
    public void setUp(@Optional("false") boolean useCloudEnv,
                      @Optional("browserstack") String envName,
                      @Optional("https://www.google.com") String url,
                      @Optional("OS X") String os,
                      @Optional("Ventura") String osVersion,
                      @Optional("chrome") String browserName,
                      @Optional("108") String browserVersion) throws MalformedURLException
    {
        // @optional on l'utilise pour le cas où

//    public void setUp(){
        // je fais l'appel pour getDriver
//      getDriver(url);
        // WebDriver driver;  // créer cette instance 'selenium'
        // l'enlever localement et le mettre globalement
//        System.setProperty("driver.chromedriver","driver.ChromeDriver\",\"C:\\Users\\rezzi\\IdeaProjects\\qaw-fr-001-automation\\driver\\chromedriver");
        //responsable du réglage du pilote, automatiquement selenium me télécharge le pilote du browser que je veux utiliser
        // j'indique à driver ou est le fichier(pilote) 'java'
//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        // je veux acceder à sauce demo.com
            if (useCloudEnv){
                getCLoudDriver(envName,os,osVersion,browserName,browserVersion,username,password);
            }else {
//                getDriver(os, browserName);
                getDriver(browserName);
            }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // hard coding
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(implicitWait)));// puisque je récupère des string du fichier config.properties, je dois les parser
        if (windowMaximaze.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }
//        driver.manage().window().maximize(); // pour maximiser le browser
//        driver.get("https://www.saucedemo.com");
        driver.get(url);
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.get("https://jqueryui.com/droppable/");
        LOG.info("browser open success"); // ne fait pas partie du test plutot du setup
    }
//    @AfterMethod // une notation qui vient de junit; on a pas besoin d'appeler close();
//    public void close(){
//        driver.close();
//        driver.quit();
//        LOG.info("browser close success");
//    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    // pour pouvoir importer les classes befor et after je dois aller dans pox.xml et effacer <scope>


//    public void clickOn(String locator){  // on crée une méthode générique
//        try {
//            driver.findElement(By.cssSelector(locator)).click();
//        }catch(Exception e){
//            driver.findElement(By.xpath(locator)).click();
//        }
//    }

//    public String getPageUrl(){
//        return driver.getCurrentUrl();
//    }

    public String getPageUrl(WebDriver driver1){
        return driver1.getCurrentUrl();
    }


    public void clickOn(WebElement element){
        element.click();
    }

//    public void type(String locator, String text){  // on crée une méthode générique
//        element.sendKeys(text);
//        try {
//            driver.findElement(By.cssSelector(locator)).sendKeys(text);
//        }catch(Exception e){
//            driver.findElement(By.xpath(locator)).sendKeys(text);
//        }
//    }
    public void type(WebElement element , String text){
        element.sendKeys(text);
    }

    public void typeKeys(WebElement element , Keys enter){
        element.sendKeys(enter);
    }



    //    public boolean isDisplayed(String locator){  // on crée une méthode générique
//                                                 // isDisplayed faut qu'il me récupère un boolean
//        try {
//            return driver.findElement(By.cssSelector(locator)).isDisplayed();
//        }catch(Exception e){
//            return driver.findElement(By.xpath(locator)).isDisplayed();
//        }
//    }
    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isSelected(WebElement element){
        return element.isSelected();
    }


//    public String getWebElementText(String locator){
//        try {
//            return driver.findElement(By.cssSelector(locator)).getText();
//        }catch(Exception e){
//            return driver.findElement(By.xpath(locator)).getText();
//        }
//    }

    public String getWebElementText(WebElement element){
        return element.getText();
    }


//  public void waitFor(int sec) throws InterruptedException {
//        Thread.sleep(sec*1000);
//    }

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // le code de sélénium pour selectlowerToHeigherFromFilter

    public void selectFromDropdown(WebElement dropdown, String option){ // séléctionner en utilisant sélénium(select)
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(option);
        }catch (Exception e){
            select.selectByValue(option);
        }
    }

    // je crée une méthode pour hoverover
    public void hoverOver(WebDriver driver1, WebElement element){ // l'instance ici faut qu'elle soit différente de celle tout en haut
                                                // on rajoute l'element ou on veut la bouger la souris
        Actions actions = new Actions(driver1); // tout ce qui est relatif à la souris on utilise Actions (vient de sélénium)
        actions.moveToElement(element).build().perform(); // faut rajouter build et perform pour que ça réussissse
    }

    public String getElementCssValue(WebElement element){
        return element.getCssValue("color");

    }

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        LOG.info(currentDir+ File.separator+"screenshot"+File.separator+"name.png");
    }

    public void waitForElementToBeAvailable(WebDriver driver, WebElement element){ // je lui donne driver et WebElement
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element)); // je choisis la condition que je veux qu'elle se réalise et le temps maximum d'attente
        // on l'appelle explicit wait car explicitement on lui demande d'attendre l'élément que je veux avec la condition, si y'a l'eerreur il la détécte
        // je l'utilise par exemple quand un élément ne m'apparait pas et que je dois attendre qu'un autre apparaisse..etc
        // implicicit wait s'applique pour tous les éléments sans exeption (90%)
        // explicit wait s'applique pour un élément spécifique, une condition spécipcique et le temps d'attente maximal (9.9%)
        // les wait dans sélénium, on les appelle synchronisation: on va synchroniser le script(étapes du code) par rapport au téléchargement(load)
        // fluent wait (résout 0.9% des problèmes), s'applique sur un élément spécifique, une condition spécifique, temps maximal et reccurency
        // recurrency(ce qui veut dire chaque un instatnt donné cherche s'il est là ou pas)
    }
    // cette methode nous permet de faire une seule
//    public void captureScreenshot(String screenshot){
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // le parser et le type de screen et je l'enregistre dans un fichier java file
//        try {
//            FileUtils.copyFile(file,new File("screenshots/"+screenshot+".png")); // vient de java linkth
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    // je l'appelle dans un moment donné, elle rajoute des dates si y'en a plusieurs screenshots
//    public void takeScreenshot(String screenshotName){
//        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
//        Date date = new Date();
//        df.format(date);
//
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+" "+df.format(date)+".png"));
//            //("Screenshot captured");
//        } catch (Exception e) {
//            try {
//                FileUtils.copyFile(file, new File( System.getProperty("user.dir")+"/screenshot/"+screenshotName+" "+df.format(date)+".jpeg"));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//        //("Screenshot captured");
//        //("Exception while taking screenshot "+e.getMessage());
//    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].ScrollIntoView", element);
    }





    public void captureScreenshot(String screenshot){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots"+File.separator+screenshot+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
//            LOG.info(File.separator);
//            LOG.info(Utility.currentDir);
            FileUtils.copyFile(file, new File(Utility.currentDir+File.separator+"screenshots"+File.separator+screenshotName+" "+df.format(date)+".png"));
            //("Screenshot captured");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //("Screenshot captured");
        //("Exception while taking screenshot "+e.getMessage());
    }







// le but c'est de ne pas utiliser aucune instance de driver
}



