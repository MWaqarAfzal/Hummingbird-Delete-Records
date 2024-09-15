package hummingbird.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hummingbird.BaseTestComponent.BaseTest;
import hummingbird.PageObject.MainDashboard;

public class DashboardTest extends BaseTest{

    public MainDashboard dashboard;
    @Test (dataProvider="getURLs")
    public void DashboardLoading(HashMap<String, String> input) throws InterruptedException
    {
        dashboard = new MainDashboard(driver);
        dashboard.mainDashboardLoading();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URl " + currentURL);
        Assert.assertEquals(currentURL, input.get("dashboardurl"));
    }

    
    @DataProvider
    public Object[][] getURLs() throws IOException
    {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\hummingbird\\Data\\URL.json");
        return new Object[][] {{data.get(0)}};
    }
    

}
