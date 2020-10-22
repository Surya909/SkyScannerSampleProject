
  @web
  Feature: search
	
	As a tester
    I want to do search in home page
    So that I can see search results
  
  
	
  Scenario: Search for a product shows related results
	Given I enter a product name in search bar
	#When I click on search
	#Then I should see related product results
	
	Scenario: Click on I'm feeling lucky should display doodle text
	  When I click on I'm feeling lucky
	  Then I should see doodle text
	
  Scenario: Click on sign in should display remove an account
     When I click on sign in button
     Then I should see remove an account
	
  Scenario: Click on images should display images in next page
     When I Click on images button
     Then I should see images text
  
  
	
  Scenario: open asos
  When I navigate to asos
	
  Then I Should land on mens section
  
  
	
	
	Scenario: click on women navigates to women page
	  When I navigate to asos
	  And I click on women
	  Then I should navigate to women page
  
	
  
  Scenario: Hoover on 'new in' in women displays view all tab
  Given I navigate to asos
  When I click on women
  And I hoover on 'new in'
  Then I should see 'view all'
  
	
  Scenario:'new in' tab should consists of seven links
	  Given I navigate to asos
	  When I click on women
	  And I hoover on 'new in'
  Then I should see seven links
  
	
  Scenario: 'clothing'tab should consists of all links
  	Given I navigate to asos
	  When I click on women
	  And I hoover on 'clothing'
  Then I Should see all links
  
	
	
	Scenario:Hoovering on 'new in' should show shoes
	  Given I navigate to asos
	  When I click on women
	  And I hoover on 'new in'
      Then I should see shoes
  
  
	
  Scenario: Landing on mens page should show students get discount limited time only  (assert text)
	  When I navigate to asos
	  Then I Should land on mens section
	  And I should see students get twenty percent off limited time only
  
	
  Scenario: Click on free delivery and returns in homepage navigates to delivery and returns page (assert text)
	Given I navigate to asos
	When I click on free delivery and returns in homepage
	  Then I should navigate to delivery and returns page
  
  
	
  Scenario: Click on returns tab in delivery and returns should show the url as returns (assert url)
	Given I navigate to asos
	When I click on free delivery and returns in homepage
	And I click on returns tab
	Then I should see the url as returns
  
  
	
  Scenario: Search for adidas Should display result as 'search results for adidas' (assert text)
	  Given I navigate to asos
	  When I enter adidas in search bar
	  And I click on search
	  Then I should see result as 'search results for adidas'
  
	
  Scenario: Click on search bar should display clear tab (assert text)
	  Given I navigate to asos
	  When I enter adidas in search bar
	  And I click on search
     And I click on search bar
     Then I should see clear tab
  
	
  Scenario: Landing on mens page should show students get discount plus more good stuff
	  Given I navigate to asos
  	When I Should land on mens section
  	Then I should see students get discount plus more good stuff
	
	
  Scenario: Landing on mens page should show try before you buy
	Given I navigate to asos
	When I Should land on mens section
  	Then I should see try before you buy
  
	
  Scenario: Landing on mens page should show destination VIP
	Given I navigate to asos
	When I Should land on mens section
  	Then I should see destination VIP
	  
	
  Scenario: 'Activewear' tab should consists of all links
	Given I navigate to asos
	When I land on mens section
  	And I hoover on 'Activewear'
  	Then I Should see all links
  
	
	Scenario: face+body tab should consists of ten links
	Given I navigate to asos
	When I land on mens section
	And I hoover on 'face plus body'
  	Then I should see ten links
  
	
  Scenario: Click on 'gifts for her' in gifts tab should show women's gifts
	  Given I navigate to asos
	  When I hoover on 'gifts'
	  And I click on 'gifts for her' tab
  Then I should see women's gifts
  
	
   Scenario: Hoover on account Icon should show My Account
  	Given I navigate to asos
  	When I hoover on account icon
  	Then I should see my account
  
  
	
  Scenario: Click on saved items icon should show you have no saved items
  Given I navigate to asos
  When I click on saved items icon
  Then I should see you have no saved items
  
	
  Scenario: Click on bag icon should show your bag is empty
  Given I navigate to asos
  When I click on bag icon
  Then I should see your bag is empty
  
	
  Scenario: Click on join should show 'sign up with'
	  Given I navigate to asos
	  When I hoover on account icon
	  And I click on join
	  Then I should see sign up with
  
	
	Scenario: Hoover on gifts should show men gifts
	  Given I navigate to asos
	  When I hoover on 'gifts'
	  Then I should see men gifts
  
	
	Scenario:selection of gender should dispaly men
	  When I navigate to asos
	  And I enter adidas in search bar
	  And I click on search
	  And I select men in gender
	  Then  I should see men is selected in dropdown
  
	
	  Scenario: selection of brand should show  selected brand name
	Given I navigate to amazon
	And I enter a product name in amazon search bar
	When I select a brand
	  Then I should see selected brand
  
	
	Scenario: search for a product should display respective results
	  Given I navigate to amazon
	  When I enter a product name in amazon search bar
	  Then I should see respective results
  
	
	Scenario: click on clear should clear all selected brands
	  Given I navigate to amazon
	  And I enter a product name in amazon search bar
	  And I select a brand
	  And I should see selected brand
	  When I click on clear
	  Then I should see all brand are unselected
  
	
	Scenario Outline: Get product prices
	 Given I navigate to asos
	  And I enter a "<product>" name in asos search bar
	  When I get product price list
	  #Then I should see product prices
	  
	  Examples:
	  |product|
	  |nike|
  
	
	  Scenario: Add product to bag should display a product in basket
		Given I navigate to asos
		And I enter a product name in search bar
		And I select a product
		When I add product to bag
	  And I click on bag icon
		Then I should see a product in basket
		
		Scenario:
  
	
		Scenario: Delete a product in basket should show 'your bag is empty'
		Given I navigate to asos
	  	And I enter a product name in search bar
	  And I select a product
	  And I add poduct to bag
	  And I click on bag icon
	  And I see a product in basket
	  When I delete a product
	  Then I should see your bag is empty
	  
		  Scenario: Save a product to wishlist
			Given I navigate to asos
  			And I enter a product name in search bar
			And I select a product
  			When I save a product
	  		And I click on whishlist
  			Then I should see product in whishlist
  
			
	
			 Scenario:Share Icon should display pinterst and facebook icons
			   Given I navigate to asos
			   And I enter a product name in search bar
			   And I select a product
			   When I click on share button
			   Then I should see pinterst and facebook icons
  
	
	Scenario: Show more should show more info about product
  Given I navigate to asos
  And I enter a product name in search bar
  And I select a product
  When I click on show more
  Then I should see more info about product
  
	
 Scenario: Show less should show less info about product
	  Given I navigate to asos
	  And I enter a product name in search bar
	  And I select a product
	  When I click on show less
	  Then I should see less info about produt
  
	
   Scenario: Sort out by high to low
	 Given I navigate to asos
	 And I enter a product name in search bar
	 When I select high to low in sort
	 Then I should see prices are arranged from high to low
	 
	
	 Scenario: Sort out by low to high
	   Given I navigate to asos
	   And I enter a product name in search bar
	   When I select low to high in sort
	   Then I should see prices are arranged from low to high
  
	
	   Scenario: Show by gender
		 Given I navigate to asos
		 And I enter a product name in search bar
		 When I select gender
		 Then I should see according to gender
		 
		 Scenario: Shop by colour
		   Given I navigate to asos
		   And I enter a product name in search bar
		   When I Select a colour
		   Then I should see specific colour
  
  
	
	  Scenario: open skyscanner
	  When I navigate to skyscanner
	  Then I should land on search page
  
	@Search
	Scenario:Search for direct flights
	  Given I navigate to skyscanner
	  When I enter details
	  Then I should see only direct flights in results
	  
	  
	  
	  
	  
	  Scenario:  click on one stop should show one stop
		Given I navigate to skyscanner
		And I enter details
		And I click on search
		And I select one stop
		Then I should see one stop flights
		
		Scenario: click on Fly out and back using the same airports shoud show related results
		  Given I navigate to skyscanner
		  And I enter details
		  And I click on search bar
		  And I Select Fly out and back using the same airports
		  Then I should see related results
  
	
		  Scenario: open crmpro
			When I navigate to crmpro
			Then I should land on login page
  
  
	
	  Scenario: click on login button should direct to home page
			Given I navigate to crmpro
			When I enter user name and password
			And I click on login button
			Then I should land on home page