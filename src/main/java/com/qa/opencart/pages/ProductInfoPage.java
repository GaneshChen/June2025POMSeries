package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productHeader = By.tagName("h1");

        public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getProductHeader(){
    String productHeaderValue =
            elementUtil.waitForElementVisible(productHeader,AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
    System.out.println("Product Header ===> "+ productHeaderValue);
    return productHeaderValue;
    }



}
