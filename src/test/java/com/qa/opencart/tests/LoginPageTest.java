package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest(){
       String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TILE);
    }

    @Test
    public void loginPageURLTest(){
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
    }

    @Test
    public void forgotPwdlinkExistsTest(){
       Assert.assertTrue(loginPage.isForgotPwdLinkExists());
    }

    @Test
    public void logoExistsTest(){
        Assert.assertTrue(loginPage.isLogoExist());
    }

    @Test(priority = Integer.MAX_VALUE)
    public void loginTest() throws InterruptedException {
        acctPage  = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertEquals(acctPage.getAccountsPageTitle(),AppConstants.ACCOUNTS_PAGE_TITLE);
    }

}
