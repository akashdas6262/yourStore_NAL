package yourStore_StepDef;

import baseUtility.BaseTest;
import baseUtility.xlsxReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import yourStore_Objects.LoginAndResister_PO;

import java.io.IOException;
import java.time.Duration;


public class AddItemToCart extends BaseTest {
    public AddItemToCart() {
    }

    LoginAndResister_PO ObjLogin;
    xlsxReader readexcel = new xlsxReader();
    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    @And("Login screen opens and user login with resistered credential")
    public void loginScreenOpensAndUserLoginWithResisteredCredential() throws IOException, InterruptedException {
        ObjLogin = new LoginAndResister_PO(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(ObjLogin.ResisteredEmailID));
        readexcel.readExcelData("C:/Users/hp/OneDrive/Desktop/yourStoreInputData.xlsx");
        String Email = readexcel.getData(0, 1, 2);
        ObjLogin.ResisteredEmailID.sendKeys(Email);
        String PWD = readexcel.getData(0, 1, 4);
        ObjLogin.ResisteredPWD.sendKeys(PWD);
        ObjLogin.UserLogin.click();
        Thread.sleep(2000);
    }

    @Then("User redirected back to home screen")
    public void userRedirecctedBackToHomeScreen() {
        ObjLogin.Homelogo.click();
    }

    @And("User opens Desktop section and add one item to cart")
    public void userOpensDesktopSectionAndAddOneItemToCart() throws InterruptedException {

        MouseHover(ObjLogin.Desktop);
        Thread.sleep(4000);
        for (WebElement Desktopoptions : ObjLogin.DesktopOptions) {
            if (Desktopoptions.getText().contains("1")) {
                Desktopoptions.click();
            }

        }
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,280)", "");
        ObjLogin.DesktopMac
                .click();
        String AddItemMessage = ObjLogin.ItemAddMessage.getText();
        System.out.println(AddItemMessage);
        String refractedAddItemMessage = AddItemMessage.replace(" iMac to your shopping cart!", "");
        System.out.println(refractedAddItemMessage);
        if (!refractedAddItemMessage.equals(" Success: You have added ")) {
            ObjLogin.ShoppingCart.click();
        }

    }

    @Then("User verifies item present in the cart")
    public void userVerifiesItamPresentInTheCart() {

    }

    @Then("User remove item if not available")
    public void userRemoveItemIfNotAvailable() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
