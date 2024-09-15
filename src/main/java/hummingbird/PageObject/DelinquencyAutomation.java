package hummingbird.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class DelinquencyAutomation extends CommonMethods{
    
    WebDriver driver;
    public DeleteRecords deleteRecord;
    public DelinquencyAutomation(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String settingOptionName = "Delinquency Automation";

    @FindBy(xpath="//div[normalize-space()='Delinquency Automation']")
    WebElement delinquencyAutomationText;

    @FindBy(xpath="//tbody/tr/td[2]/span/span/span")
    List<WebElement> propertiesColumn;

    @FindBy(xpath="//tbody/tr/td[2]/span/span/span")
    WebElement propertiesColumntext;

    @FindBy(xpath="//tbody/tr/td[5]/span/span/span")
    List<WebElement> actionColumn;

    public void deleteDelinquencyAutomationRecordsWithoutAssignedProperties() throws InterruptedException
    {
        deleteRecord = new DeleteRecords(driver);
        deleteRecord.clickOnSettingOption(settingOptionName, delinquencyAutomationText);
        deleteRecord.deleteRecords(propertiesColumntext, propertiesColumn, actionColumn);
    }

}
