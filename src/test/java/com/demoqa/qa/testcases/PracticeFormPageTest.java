package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import com.demoqa.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeFormPageTest extends TestBase {

    HomePage homePage;
    PracticeFormPage practiceFormPage;
    String sheetName="Sheet1";

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        practiceFormPage = homePage.clickOnPracticeFormLink();
    }

//    @Test(priority=1)
//    public void validatePageHeaderTitleTest(){
//        Assert.assertEquals(practiceFormPage.validatePageHeaderTitle(),"Practice Form");
//    }
//
//    @Test(priority=2)
//    public void validateHeading(){
//        Assert.assertEquals(practiceFormPage.validateHeading(),"Student Registration Form");
//    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(priority=3, dataProvider="getTestData")
    public void validateRegisterNewStudent(String fName, String lName, String mailID, String gender,
                                           String mNumber, String dt, String month, String year,
                                           String cAddress){
        practiceFormPage.registerNewStudent(fName, lName, mailID, gender, mNumber, dt, month, year, cAddress);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
