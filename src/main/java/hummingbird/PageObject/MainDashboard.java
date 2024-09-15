package hummingbird.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class MainDashboard extends CommonMethods{

    WebDriver driver;

    public MainDashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className= "inline-loader")
    WebElement globalSearchLoader;

    public void mainDashboardLoading() throws InterruptedException
    {
        waitVisibilityofElement(globalSearchLoader);
    }

}
