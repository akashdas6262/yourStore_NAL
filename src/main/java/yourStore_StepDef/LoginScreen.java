package yourStore_StepDef;

import baseUtility.BaseTest;
import baseUtility.xlsxReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import yourStore_Objects.LoginAndResister_PO;

import java.io.IOException;

public class LoginScreen extends BaseTest{
    public LoginScreen() {

    }

    LoginAndResister_PO ObjLogin;
    xlsxReader readexcel = new xlsxReader();
    public BaseTest bt = new BaseTest();

    @Given("User open browser")
    public void user_open_browser() {
        driver = new ChromeDriver();

    }

    @And("Navigate to yourStore application")
    public void navigate_to_your_store_application() {
        bt.lunchApplication();
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("Homepage Displayed" + "  " + "(" + title.equals("Your Store") + ")");
    }

    @When("user click My Account button")
    public void userClickMyAccountButton() throws InterruptedException {
        ObjLogin = new LoginAndResister_PO(driver);
        ObjLogin.MyAccount.click();
        Thread.sleep(2000);
    }

    @When("User click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        ObjLogin.LoginButton.click();
        Thread.sleep(3000);
    }

    @Then("Login screen open with NewCustomer and Returning Customer tab")
    public void loginScreenOpenWithNewCustomerAndReturningCustomerTab() {
        String NewCustomerHeader = ObjLogin.NewCustomerBlock.getText();
        String ReturingCustomerHeader = ObjLogin.ReturningCustomerBlock.getText();
//        System.out.println(NewCustmerHeader);
//        System.out.println(ReturingCustmerHeader);
        if (ObjLogin.NewCustomerBlock.isDisplayed()) {
            System.out.println("New Customer block is available");
        }
        if (ObjLogin.ReturningCustomerBlock.isDisplayed()) {
            System.out.println("Returning Customer block is available");
        }
    }

    @Then("user Continue with NewCustomer option")
    public void userContinueWithNewCustomerOption() {
        ObjLogin.ContinueButton.click();
    }


    @Then("user set login details and check privacy policy & click continue")
    public void userSetLoginDetailsAndCheckPrivacyPolicyClickContinue() throws IOException, InterruptedException {

        readexcel.readExcelData("C:/Users/hp/OneDrive/Desktop/yourStoreInputData.xlsx");
        String Firstname = readexcel.getData(0, 1, 0);
        System.out.println(Firstname);
        String Lastname = readexcel.getData(0, 1, 1);
        System.out.println(Lastname);
        String Email = readexcel.getData(0, 1, 2);
        System.out.println(Email);
        String Telephone = readexcel.getData(0, 1, 3);
        String Password = readexcel.getData(0, 1, 4);
        String Confirm = readexcel.getData(0, 1, 5);

        ObjLogin.firstname.sendKeys(Firstname);
        ObjLogin.lastname.sendKeys(Lastname);
        ObjLogin.email.sendKeys(Email);
        ObjLogin.telephone.sendKeys(Telephone);
        ObjLogin.password.sendKeys(Password);
        ObjLogin.confirm.sendKeys(Confirm);
        ObjLogin.agree.click();
        ObjLogin.ContinueResisterScreen.click();
        Thread.sleep(5000);
    }

    @Then("User see Your Account Has Been Created! message")
    public void userSeeYourAccountHasBeenCreatedMessage() throws InterruptedException {
        String ReststerpageTitle = driver.getTitle();
        if (ReststerpageTitle.equals("Your Account Has Been Created!")) {
            System.out.println("Account successfully created" + " " + ":)");
            Thread.sleep(6000);
        }
    }

    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }


}
