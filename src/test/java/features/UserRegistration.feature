Feature: User Registration
   I want to check that the user can register in our e-commerce website.
   
	Scenario Outline:  User Registration
	Given the user in the home page
	When I click on register link
	And I entered "<firstname>","<lastname>","<email>","<password>"
	Then The registration page displayed successfully
	
	Examples: 
	|firstname|lastname|email|password|
	|ahmed|mohamed|ahmed1422236@yahoo.com|5372235365|
	|Hussen|Nashaat|hUSEe12n@yahoo.com|5341631872397|
	|ahmed|mohamed|ahmed2124236@yahoo.com|5372235365|
	|Hussen|Nashaat|hUS1E3en@yahoo.com|5341631872397|
	|ahmed|mohamed|ahme1d514236@yahoo.com|5372235365|
	|Hussen|Nashaat|hUSEe47n@yahoo.com|5341631872397|

 	  