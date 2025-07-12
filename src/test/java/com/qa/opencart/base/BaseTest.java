package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;


public class BaseTest {

    WebDriver driver;
    DriverFactory df;
    protected LoginPage loginPage;
    protected Properties prop;
    protected AccountsPage acctPage;
    protected ResultsPage resultsPage;
    protected ProductInfoPage productInfoPage;
    protected RegisterPage registerPage;

    @BeforeTest
    public void setUp(){
        df = new DriverFactory();
        prop = df.initProp();
        driver=df.initDriver(prop);
        loginPage = new LoginPage(driver);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
