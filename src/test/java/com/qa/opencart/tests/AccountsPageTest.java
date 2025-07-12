package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accSetUp(){
        acctPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }
    @Test
    public void accPageTitleTest(){
        String actTitle = acctPage.getAccountsPageTitle();
        Assert.assertEquals(actTitle,AppConstants.ACCOUNTS_PAGE_TITLE);
    }
    @Test
    public void isLogoutLinkExistsTest(){
        Assert.assertTrue(acctPage.isLogOutLinkExist());
    }
    @Test
    public void accPageHeadersCountTest(){
     Assert.assertEquals(acctPage.getTotalAccountsPageHeader(),AppConstants.ACCOUNTS_PAGE_HEADER_COUNT);
    }

    @Test
    public void accPageHeadersTest(){
       List<String> actualHeadersList =  acctPage.getAccPageHeaders();
       Assert.assertEquals(actualHeadersList,AppConstants.ACTUAL_ACC_PAGE_HEADERS_LIST);
    }

    @DataProvider
    public Object[][] getSearchKey(){
        return new Object[][] {
                {"MacBook",3},
                {"imac",1},
                {"samsung",2}
        };
    }

    @Test (dataProvider = "getSearchKey")
    public void searchCountTest(String searchKey, int searchCount){
        resultsPage = acctPage.doSearch(searchKey);
        Assert.assertEquals(resultsPage.getSearchResultsCount(),searchCount);
    }

    @DataProvider
    public Object[][] getSearchData(){
        return new Object[][] {
                {"MacBook","MacBook Pro"},
                {"Macbook","MacBook Air"},
                {"imac","iMac"},
                {"samsung","Samsung SyncMaster 941BW"},
                {"samsung","Samsung Galaxy Tab 10.1"}
        };
    }
    @Test (dataProvider = "getSearchData")
    public void searchTest(String searchKey, String productName){
        resultsPage = acctPage.doSearch(searchKey);
        productInfoPage =resultsPage.selectProduct(productName);
        Assert.assertEquals(productInfoPage.getProductHeader(),productName);
    }
}
