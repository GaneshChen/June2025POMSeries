package com.qa.opencart.factory;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @Author Ganesh Chenkalvarayan
 */
public class DriverFactory {

    WebDriver driver;
    Properties properties;

    /**
     *This Method is used to init the driver on the basis of given BrowserName.
     *
     *
     */
    public WebDriver initDriver(Properties properties) {

        String browserName = properties.getProperty("browser");
        System.out.println("Browser Name is :"+browserName);
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver= new EdgeDriver();
                break;
            case "safari":
                driver=new SafariDriver();
            default:
                System.out.println(AppError.INVALID_BROWSER_MSEG +browserName);
                throw new BrowserExceptions(AppError.INVALID_BROWSER_MSEG+browserName);


        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
        return driver;
    }

    /**
     * This Method is used to Initialize the Properties from the Config File.
     * @return
     */
    public Properties initProp(){
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
