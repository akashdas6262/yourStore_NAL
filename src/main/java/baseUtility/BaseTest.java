package baseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BaseTest {

    public static WebDriver driver;
//    Actions act= new Actions(driver);

//    public void invokeBrowser() {
//        driver = new ChromeDriver();
//    }

    public void lunchApplication() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public WebElement MouseHover(WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
        return ele;
    }


}
