package hummingbird;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class CommonLocators extends CommonMethods{

    WebDriver driver;
    public CommonLocators(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 /*   @FindBy(className = "mdi-settings")
    public WebElement settingsIcon;

    @FindBy(xpath="//div[normalize-space()='Settings Dashboard']")
    public WebElement settingsDashboardText;

    @FindBy(css="div[class*='v-list-item__content']")
    public List<WebElement> settingsMenuList;

    @FindBy(css="div[class='v-list-item__title']")
    public List<WebElement> actionOptions;

    @FindBy(className="hb-modal-title-font-size")
    public WebElement deletePopupTitle;

    @FindBy(xpath="//span[@class='font-weight-regular hb-button-text-regular hb-btn-white-text']")
    public WebElement deleteButton;*/

}
