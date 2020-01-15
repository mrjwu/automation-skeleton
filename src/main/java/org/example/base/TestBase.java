package org.example.base;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.util.TestUtil;
import org.example.util.WebEventListener;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static String currentDir = System.getProperty("user.dir");

    public RequestSpecification REQUEST;
    public Faker FAKER = new Faker();

    // super() calls parent class’ constructors only
    public TestBase(){
        String log4jConfPath = currentDir+"/src/main/java/org/example/config/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
                    + "/org/example/config/config.properties");
            prop.load(ip);

            RestAssured.baseURI = prop.getProperty("api.uri");
            //RestAssured.port = Integer.valueOf(prop.getProperty("api.port"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        REQUEST = RestAssured.given().contentType(ContentType.JSON);
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", currentDir+"/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", currentDir+"/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        // Logging
        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}