/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hummingbird.BaseTestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hummingbird.PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * @author wafzal
 */
public class BaseTest {

    public WebDriver driver;

    public WebDriver driverInitilizer() throws IOException, InterruptedException
    {        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException
    {
        //		Read JSON to String
        String jsonContent = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

        //		Convert String to HASH MAP by using JACKSON DATABIND Repository
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
        
        return data;
    }

    @BeforeMethod
    public void browserInitilizer() throws IOException, InterruptedException
    {
                //	CREATE OBJECT OF PROPERTY CLASS
		Properties prop = new Properties();	
		//	SET THE PATH OF THE GLOBAL PROPERTY FILE
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\Resources\\GlobalData.properties");
		//	LOAD THE BLOBAL PROPERTY FILE
		prop.load(fis);
        driver = driverInitilizer();
        String loginURL = prop.getProperty("url");
        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        driver.get(loginURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
    }

}
