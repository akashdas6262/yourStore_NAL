package yourStore_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginAndResister_PO {
    WebDriver driver;
    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement MyAccount;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[2]")
    public WebElement LoginButton;
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    public WebElement NewCustomerBlock;
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    public WebElement ReturningCustomerBlock;
    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement ContinueButton;
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstname;
    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastname;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='telephone']")
    public WebElement telephone;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name='confirm']")
    public WebElement confirm;
    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agree;
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement ContinueResisterScreen;


    @FindBy(xpath = "//input[@name='email']")
    public WebElement ResisteredEmailID;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement ResisteredPWD;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement UserLogin;
    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement Homelogo;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]")
    public WebElement Desktop;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]/div/div/ul/li")
    public List<WebElement> DesktopOptions;
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    public WebElement DesktopMac;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement ItemAddMessage;
    @FindBy(xpath = "//*[contains(text(),'Shopping Cart')]")
    public WebElement ShoppingCart;
    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr")
    public List<WebElement> ProductListInCart;


    public LoginAndResister_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
