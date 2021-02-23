Feature: Account Page Feature

Background:
Given User has already logged in to application
 | username | password |
 | abhi@gmail.com | abhishek |
 
 @accounts
 Scenario: Accounts page title
 Given user is on Accounts page
 When user gets the title of the page
 Then page title should be "My account - My Store"
 
 @accounts
 Scenario: Account Section Count
 Given user is on nextAccounts Page
 Then user gets account section
 | ORDER HISTORY AND DETAILS |
 | MY CREDIT SLIPS |
 | MY ADDRESSES |
 | MY PERSONAL INFORMATION |
 | MY WISHLISTS |
 | HOME |
 And accounts section count should be 6