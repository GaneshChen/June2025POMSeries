package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class DemoPage {

    By loc = By.cssSelector("Demo");
    int i = 10;
    public int get(){
        System.out.println("Click on Demo");
        return 0;
    }
}
