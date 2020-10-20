package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeFormPage extends TestBase {

    //Page Factory (or) Object Factory
    @FindBy(xpath="//div[@class='main-header' and text()='Practice Form']")
    @CacheLookup
    WebElement pageHeaderTitle;

    @FindBy(xpath="//h5[text()='Student Registration Form']")
    @CacheLookup
    WebElement heading;

    @FindBy(xpath="//div[text() = 'Forms' and @class= 'header-text']")
    @CacheLookup
    WebElement formsLink;

    @FindBy(xpath="//span[@class='text' and text()='Practice Form']")
    @CacheLookup
    WebElement practiceFormLink;

    @FindBy(xpath="//input[@id='firstName']")
    @CacheLookup
    WebElement firstName;

    @FindBy(xpath="//input[@id='lastName']")
    @CacheLookup
    WebElement lastName;

    @FindBy(xpath="//input[@id='userEmail']")
    @CacheLookup
    WebElement email;

    @FindBy(xpath="//label[text()='Male']")
    @CacheLookup
    WebElement maleBtn;

    @FindBy(xpath="//label[text()='Female']")
    @CacheLookup
    WebElement femaleBtn;

    @FindBy(xpath="//label[text()='Other']")
    @CacheLookup
    WebElement otherBtn;

    @FindBy(xpath="//input[@id='userNumber']")
    @CacheLookup
    WebElement mobileNumber;

    @FindBy(xpath="//input[@id='dateOfBirthInput']")
    @CacheLookup
    WebElement calendar;

    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    @CacheLookup
    WebElement monthSelect;

    @FindBy(xpath="//select[@class='react-datepicker__year-select']")
    @CacheLookup
    WebElement yearSelect;

    @FindBy(xpath="//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
    @CacheLookup
    WebElement subject;

    @FindBy(xpath="//textarea[@id='currentAddress']")
    @CacheLookup
    WebElement currentAddress;

    @FindBy(xpath="//button[@id='submit' and @class='btn btn-primary' and @type='submit']")
    @CacheLookup
    WebElement submitBtn;


    //Initializing the Page Factory objects
    public PracticeFormPage(){
        PageFactory.initElements(driver, this);

    }

    //methods to perform actions in the page.
    public String validatePageHeaderTitle(){
        practiceFormLink.click();
        return pageHeaderTitle.getText();
    }

    public String validateHeading(){
        practiceFormLink.click();
        return heading.getText();
    }

    public void registerNewStudent(String fName, String lName, String mailID, String gender,
                                   String mNumber, String dt, String month, String year,
                                   String cAddress){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mailID);

        if(gender.equalsIgnoreCase("male")){
            maleBtn.click();
        }else if(gender.equalsIgnoreCase("female")){
            femaleBtn.click();
        }
        else{
            otherBtn.click();
        }

        mobileNumber.sendKeys(mNumber);

        calendar.click();
        Select ySelect = new Select(yearSelect);
        ySelect.selectByVisibleText(year);
        Select mSelect = new Select(monthSelect);
        mSelect.selectByVisibleText(month);
        List<WebElement> dates = driver.findElements(By.xpath("//div[@role='listbox']//div//descendant::div"));
        for(WebElement elem : dates){
            if(elem.getText().trim().equals(dt)){
                elem.click();
                break;
            }
        }

        currentAddress.sendKeys(cAddress);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", submitBtn);
    }
}
