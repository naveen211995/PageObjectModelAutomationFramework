package com.demoqa.qa.base;

import com.demoqa.qa.util.WebEventListener;
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

    public TestBase(){
        prop = new Properties();
        try {
            FileInputStream fs = new FileInputStream("F:\\Selenium\\Selenium_Projects\\DemoQATest\\src\\main\\java\\com\\demoqa\\qa\\config\\config.properties");
            prop.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\Selenium_Drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Incompatible browser..!");
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
    }
}
