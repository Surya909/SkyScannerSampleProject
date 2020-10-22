package com.sample.pageObjects;

import com.sample.pageFactory.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends Pages {


    @FindBy(id = "origin-fsc-search")
    private WebElement origin;
    @FindBy(id = "destination-fsc-search")
    private WebElement destination;
    @FindBy(id = "depart-fsc-datepicker-input")
    private WebElement departdate;
    @FindBy(css = "tbody>tr:nth-child(2)>td:nth-child(3)")
    private WebElement selectDepartdate;
    @FindBy(id = "return-fsc-datepicker-input")
    private WebElement returndate;
    @FindBy(css = "tbody>tr:nth-child(2)>td:nth-child(7)")
    private WebElement selectReturndate;
    @FindBy(id = "fsc-class-travellers-trigger-1PZXn")
    private WebElement extradetails;
    @FindBy(css = ".SubmitButton-WxCV2")
    private WebElement searchBtn;
    @FindAll(@FindBy(css = ".no-stops"))
    private List<WebElement> directFlightsText;


    public void iNavigateToSkyscanner() {
        driver.navigate().to( "https://www.skyscanner.net/" );

    }

    public void iEnterDetails() {
        enterOrigin( "London" )
                .enterdestination( "Barcelona" )
                .departDate( "Saturday, 26 December 2020" )
                .returnDate( "Sunday, 27 December 2020" )
                .searchButton();
    }

    public SearchPage enterOrigin(String text) {
        waitForElement( origin ).sendKeys( text );
        return this;
    }

    public SearchPage enterdestination(String text) {
        waitForElement( destination ).sendKeys( text );
        return this;
    }

    public SearchPage departDate(String text) {
        waitForElement( departdate ).click();
        waitForElement( selectDepartdate ).click();
        return this;
    }

    public SearchPage returnDate(String text) {
        waitForElement( returndate ).click();
        waitForElement( selectReturndate ).click();
        return this;
    }

    public void searchButton() {
        waitForElement( searchBtn ).click();
    }

    public boolean directFlightResultsAreDisplayed() {
        boolean result = false;
        for (WebElement element : waitForElements( directFlightsText )) {
            result = element.getText().matches( "Direct " );
        }
        return result;
    }




}
