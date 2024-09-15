package hummingbird.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class AccountingSesttings extends CommonMethods{

    WebDriver driver;
    public CommonMethods commonMethods;
    public DeleteRecords deleteRecords;

    public AccountingSesttings(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String settingsOptionName = "Accounting";
    String innerPanelOption = "Templates";

    @FindBy(xpath="//div[normalize-space()='Accounting Settings']")
    public WebElement AccountingSettingsText;

    @FindBy(css="span.hb-expansion-panel-title-font-size")
    List<WebElement> accountingInnerPanel;

    @FindBy(css="span.hb-expansion-panel-title-font-size")
    WebElement accountingInnerPanelOptions;

    @FindBy(xpath="//td[contains(text(),'Properties')]")
    List<WebElement> propertiesColumn;

    @FindBy(xpath="//tbody/tr/td[3][@class='text-start']")
    WebElement propertiesColumntext;

    @FindBy(xpath="//tbody/tr/td[5]/span/span/span")
    List<WebElement> actionColumn;

    public void deleteAccountingTemplatesRecordsWithoutAssignedProperties() throws InterruptedException
    {
        deleteRecords = new DeleteRecords(driver);
        commonMethods = new CommonMethods(driver);
        deleteRecords.clickOnSettingOption(settingsOptionName, AccountingSettingsText);
        waitVisibilityofElement(accountingInnerPanelOptions);
        commonMethods.clickOnRequiredOptionFromList(accountingInnerPanel, propertiesColumntext, innerPanelOption);
        deleteRecords.deleteRecords(propertiesColumntext, propertiesColumn, actionColumn);
    }
}
