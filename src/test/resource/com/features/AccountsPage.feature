Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|afpzsvboo@10mail.org|Selenium12345|

Scenario: Accounts page title 
Given user is on Accounts page
When user gets the title of the page 
Then page title should be "My account - My Shop"

Scenario: Accounts Section count
Given user is on Accounts page 
Then user gets accounts section
|Add my first address|
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
And accounts section count should be 5
