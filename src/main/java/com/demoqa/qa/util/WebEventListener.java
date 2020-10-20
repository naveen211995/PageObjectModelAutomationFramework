package com.demoqa.qa.util;

import com.demoqa.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebEventListener extends TestBase implements WebDriverEventListener {

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '"+ url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: '"+ url +"'");
    }

    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find element by: " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element by: " +by.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " +element.toString());
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charSequences) {
        System.out.println("Value of the: " + element.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + element.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occured: " + error);
        try {
            TestUtil.takeScreenshotAtEndOfTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Non-overridden methods
    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver driver) {

    }

    public void afterGetText(WebElement webElement, WebDriver driver, String s) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeScript(String s, WebDriver driver) {

    }

    public void afterScript(String s, WebDriver driver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver driver) {

    }

    public void afterSwitchToWindow(String s, WebDriver driver) {

    }
}
