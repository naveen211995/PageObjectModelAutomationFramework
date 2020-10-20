package com.demoqa.qa.testcases;

import com.demoqa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends TestBase {

    //Page Factory (or) Object Factory
    @FindBy(xpath="//div[@class='main-header' and text()='Text Box']")
    @CacheLookup
    WebElement pageHeaderTitle;

    @FindBy(xpath="//img[@src='/images/Toolsqa.jpg']")
    @CacheLookup
    WebElement pageHeadline;

    @FindBy(xpath="//span[@class='text' and text()='Text Box']")
    @CacheLookup
    WebElement textBoxLink;

    @FindBy(xpath="//div[text() = 'Elements' and @class= 'header-text']")
    @CacheLookup
    WebElement elementsLink;

    //Initializing the Page Factory objects
    public TextBoxPage(){
        PageFactory.initElements(driver, this);
    }

    //methods to perform actions in the page.

    public void validateTextBoxPageTitle(){
        driver.getTitle();
    }

    public String validatePageHeaderTitle(){
        elementsLink.click();
        textBoxLink.click();
        return pageHeaderTitle.getText();
    }

    public boolean validatePageHeadline(){
        elementsLink.click();
        textBoxLink.click();
        return pageHeadline.isDisplayed();
    }

}
