Feature: Login

Scenario: Successful Login With valid credentials
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Logout
	Then Page Title should be "nopCommerce demo store. Login"
	And close browser
	
Scenario Outline: Successful Login With valid credentials
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Logout
	Then Page Title should be "nopCommerce demo store. Login"
	And close browser
	
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|
	
