Feature: Login

Scenario: Successful Login With valid credentials
	Given User Launch Chrome Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And User click on Login
	And User enters Email as "marvel01@gmail.com" and Password as "IronMan"
	And Click on login
	Then Page Title should be "Demo Web Shop"
	When User click on Logout
	Then Close browser
	
