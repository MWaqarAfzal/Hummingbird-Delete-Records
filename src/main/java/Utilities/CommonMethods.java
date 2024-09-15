package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

    WebDriver driver;
    public CommonMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitVisibilityofElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitInVisibilityofElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void click(WebElement element)
    {
        element.click();
    }

    public void clickOnRequiredOptionFromList(List<WebElement> elementList, WebElement waitedElementToDisplay, String innerPanelOption)
    {
        for(int i=0; i<elementList.size(); i++)
        {
            if(elementList.get(i).getText().equalsIgnoreCase(innerPanelOption))
            {
                elementList.get(i).click();
                waitVisibilityofElement(waitedElementToDisplay);
                break;
            }
        }
    }

}
