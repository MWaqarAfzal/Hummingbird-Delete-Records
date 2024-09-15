package hummingbird.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class LoginPage extends CommonMethods{

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css="input[name='username']")
    WebElement userName;

    @FindBy(css="input[name='password']")
    WebElement password;

    @FindBy(css = "button[name*='Login']")
    WebElement loginbutton;

    public MainDashboard login(String email, String pass) throws InterruptedException
    {
        userName.sendKeys(email);
        password.sendKeys(pass);
        loginbutton.click();
        return new MainDashboard(driver);
    }
}
