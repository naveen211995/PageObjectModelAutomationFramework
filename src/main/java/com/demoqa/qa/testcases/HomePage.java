package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //Page Factory (or) Object Factory
    @FindBy(xpath="//div[text() = 'Forms' and @class= 'main-header']")
    @CacheLookup
    WebElement pageHeaderTitle;

    @FindBy(xpath="//div[@class='header-text' and text()='Elements']")
    @CacheLookup
    WebElement elementsLink;

    @FindBy(xpath="//span[@class='text' and text()='Text Box']")
    @CacheLookup
    WebElement textBoxLink;

    @FindBy(xpath="//div[text() = 'Forms' and @class= 'header-text']")
    @CacheLookup
    WebElement formsLink;

    @FindBy(xpath="//span[@class='text' and text()='Practice Form']")
    @CacheLookup
    WebElement practiceFormLink;

    //Initializing the Page Factory objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //methods to perform actions in the page.

    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public String validatePageHeaderTitle(){
        return pageHeaderTitle.getText();
    }

    public TextBoxPage clickOnTextBoxLink(){
        elementsLink.click();
        textBoxLink.click();
        return new TextBoxPage();
    }

    public PracticeFormPage clickOnPracticeFormLink(){
        practiceFormLink.click();
        return new PracticeFormPage();
    }
}
