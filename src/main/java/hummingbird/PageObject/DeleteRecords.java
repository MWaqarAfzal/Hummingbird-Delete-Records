package hummingbird.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class DeleteRecords extends CommonMethods{
    WebDriver driver;
    public DeleteRecords(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainDashboard dashboard;

    @FindBy(className = "mdi-settings")
    WebElement settingsIcon;

    @FindBy(xpath="//div[normalize-space()='Settings Dashboard']")
    WebElement settingsDashboardText;

    @FindBy(css="div[class*='v-list-item__content']")
    List<WebElement> settingsMenuList;

    @FindBy(css="div[class='v-list-item__title']")
    List<WebElement> actionOptions;

    @FindBy(className="hb-modal-title-font-size")
    WebElement deletePopupTitle;

    @FindBy(xpath="//span[@class='font-weight-regular hb-button-text-regular hb-btn-white-text']")
    WebElement deleteButton;

    public void settingsClick(WebElement settingButton, WebElement dashBoardText)
    {
        click(settingButton);
        waitVisibilityofElement(dashBoardText);
    }

    public void clickOnSettingOption(String settingOptionName, WebElement settingsText) throws InterruptedException
    {
        dashboard = new MainDashboard(driver);
        waitInVisibilityofElement(dashboard.globalSearchLoader);
        Thread.sleep(5000);
        settingsClick(settingsIcon, settingsDashboardText);
        for(int i=0; i< settingsMenuList.size(); i++)
        {
            if(settingsMenuList.get(i).getText().equalsIgnoreCase(settingOptionName))
            {
                settingsMenuList.get(i).click();
                waitVisibilityofElement(settingsText);
                break;
            }
            
        }
    }

    public void deleteRecords(WebElement propertiesColumntext, List<WebElement> propertiesColumn, List<WebElement> actionColumn) throws InterruptedException
    {
        waitVisibilityofElement(propertiesColumntext);
        for(int i=1; i<propertiesColumn.size(); i++)
        {
            System.out.println("No of associated properties with the templates are " + propertiesColumn.get(i).getText());
            if(propertiesColumn.get(i).getText().equalsIgnoreCase("0 Properties"))
            {
                actionColumn.get(i).click();
                for(int j=0; j<actionOptions.size(); j++)
                {
                    if(actionOptions.get(j).getText().equalsIgnoreCase("Delete"))
                    {
                        actionOptions.get(j).click();
                        break;
                    }
                }
                waitVisibilityofElement(deletePopupTitle);
                Thread.sleep(2000);
                click(deleteButton);
                Thread.sleep(10000);
                i=i-1;
            }
            
        }
    }

}
