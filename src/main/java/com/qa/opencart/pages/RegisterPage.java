package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private ElementUtil elementUtil;
    public RegisterPage(WebDriver driver){
        this.driver=driver;
        elementUtil= new ElementUtil(driver);
    }


}
