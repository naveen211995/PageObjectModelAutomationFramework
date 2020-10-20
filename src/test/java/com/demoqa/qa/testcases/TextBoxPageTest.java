package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxPageTest  extends TestBase {

    TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp(){
        initialization();
        textBoxPage = new TextBoxPage();
    }

    @Test(priority=1)
    public void validatePageHeaderTitleTest(){
        Assert.assertEquals(textBoxPage.validatePageHeaderTitle(),"Text Box");
    }

    @Test(priority=2)
    public void validatePageHeadlineTest(){
        Assert.assertTrue(textBoxPage.validatePageHeadline());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
