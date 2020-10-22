
  @web
  Feature: search
	
	As a tester
    I want to do a search for flights
    So that I can see relevant search results
	
	@Search
	Scenario:Search for direct flights in skyscanner
	  Given I navigate to skyscanner
	  When I enter details
	  Then I should see only direct flights in results
	  
	  