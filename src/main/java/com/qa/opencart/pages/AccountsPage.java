package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    private By logoutLink = By.linkText("Logout");
    private By headers = By.cssSelector("div#content h2");
    private By search = By.name("search");
    private By searchIcon = By.cssSelector("div#search button");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getAccountsPageTitle() {
        String title = elementUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
        System.out.println("Accounts Page Title :" + title);
        return title;
    }

    public boolean isLogOutLinkExist() {
        return elementUtil.isElementDispalyed(logoutLink);
    }

    public int getTotalAccountsPageHeader(){
        return elementUtil.waitForElementsVisible(headers,AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
    }


    public List<String> getAccPageHeaders() {
        List<WebElement> headerslist = elementUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
        List<String> headersValueList = new ArrayList<>();
        for (WebElement e : headerslist) {
            String header = e.getText();
            headersValueList.add(header);
        }
        return headersValueList;
    }

    public ResultsPage doSearch(String searchKey){
        System.out.println("Search Key ==>"+ searchKey);
        WebElement searchEle = elementUtil.
                waitForElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT);
        elementUtil.doSendKeys(searchEle,searchKey);
        elementUtil.doClick(searchIcon);
        return new ResultsPage(driver);
    }

}
