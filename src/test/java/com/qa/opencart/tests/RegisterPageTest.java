package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void regSetUp(){
        registerPage = loginPage.navigateToRegisterPage();
    }




}
