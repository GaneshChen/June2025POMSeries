package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    //private By locators : page objects
    private By firstName = By.id("input-email");
    private  By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPasswordLink = By.linkText("Forgotten Password");
    private By logoImg = By.cssSelector(".img-responsive");
    private By registerLink = By.linkText("Register");

    //public constructors


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //public Page Actions/Methods
    public String getLoginPageTitle(){

        String title = elementUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TILE,AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Login Page Title:"+ title);
        return title;
    }

    public String getLoginPageURL(){
        String url = driver.getCurrentUrl();
        System.out.println("Login Page Title:"+ url);
        return url;
    }
    public boolean isForgotPwdLinkExists(){
       return elementUtil.isElementDispalyed(forgotPasswordLink);

    }

    public AccountsPage doLogin(String userName, String pwd)  {
        elementUtil.waitForElementVisible(firstName,AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
        elementUtil.doSendKeys(password,pwd);
        elementUtil.doClick(loginBtn);
        return new AccountsPage(driver);
    }

    public boolean isLogoExist(){
       return elementUtil.isElementDispalyed(logoImg);
    }

    public RegisterPage navigateToRegisterPage(){
        elementUtil.doClick(registerLink);
        return new RegisterPage(driver);
    }

}
