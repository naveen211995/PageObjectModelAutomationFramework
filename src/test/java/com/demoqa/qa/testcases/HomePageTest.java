package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    TextBoxPage textBoxPage;
    PracticeFormPage practiceFormPage;

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
    }

    @Test(priority=1)
    public void validateHomePageTitleTest(){
        String homePageTitle = homePage.validateHomePageTitle();
        Assert.assertEquals(homePageTitle, "ToolsQA");
    }

    @Test(priority=2)
    public void validatePageHeaderTitleTest(){
        Assert.assertEquals(homePage.validatePageHeaderTitle(),"Forms");
    }

    @Test(priority=3)
    public void clickOnTextBoxLinkTest(){
        textBoxPage = homePage.clickOnTextBoxLink();
        Assert.assertEquals(textBoxPage.validatePageHeaderTitle(), "Text Box");

    }

    @Test(priority=4)
    public void clickOnPracticeFormLinkTest(){
        practiceFormPage = homePage.clickOnPracticeFormLink();
        Assert.assertEquals(practiceFormPage.validatePageHeaderTitle(), "Practice Form");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
