package com.sample.pageFactory;


import com.google.common.base.Function;
import com.sample.pageObjects.SearchPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pages {
    public WebDriver driver;
    public static Logger log;

    public Pages() {
        this.driver = DriverHelper.driver;
        PageFactory.initElements( driver, this );
        log = Logger.getLogger( Pages.class );

    }


    public static SearchPage searchPage() {
        return new SearchPage();
    }


    public WebElement waitForElement(WebElement element) {
        try {
            return new WebDriverWait( driver, 1 ).until( ExpectedConditions.visibilityOf( element ) );
        } catch (WebDriverException e) {
            FluentWait<WebElement> fluentWait = new FluentWait<WebElement>( element );
            fluentWait.withTimeout( 15, TimeUnit.SECONDS ).pollingEvery( 10, TimeUnit.MILLISECONDS );
            fluentWait.until( new Function<WebElement, Object>() {
                @Override
                public Boolean apply(WebElement element) {
                    log.info( "Applying Fluent wait to check WebElement is Enabled" );
                    return element.isEnabled();
                }
            } );
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript( "arguments[0].scrollIntoView()", element );
        return element;
    }


    public List<WebElement> waitForElements(List<WebElement> elements) {
        try {
            return new WebDriverWait( driver, 1 ).until( ExpectedConditions.visibilityOfAllElements( elements ) );
        } catch (WebDriverException e) {
            FluentWait<List<WebElement>> fluentWait = new FluentWait<List<WebElement>>( elements );
            fluentWait.withTimeout( 15, TimeUnit.SECONDS ).pollingEvery( 1, TimeUnit.MILLISECONDS );
            fluentWait.until( new Function<List<WebElement>, Object>() {

                @Override
                public Boolean apply(List<WebElement> elements) {
                    log.info( "Applying Fluent wait to check list of WebElements are empty or not" );
                    return !elements.isEmpty();
                }
            } );
        }
        return elements;

    }


}


