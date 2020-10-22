package com.Sample.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.sample.pageFactory.Pages.searchPage;


public class SearchSteps {

    @Given("^I navigate to skyscanner$")
    public void iNavigateToSkyscanner()  {
        searchPage().iNavigateToSkyscanner();

    }
    @When("^I enter details$")
    public void iEnterDetails()  {
        searchPage().iEnterDetails();
    }
    @Then("^I should see only direct flights in results$")
    public void i_should_see_only_direct_flights_in_results()  {
       Assert.assertTrue(searchPage().directFlightResultsAreDisplayed());
    }


}






