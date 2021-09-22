#Feature: Open Aspirations home page and products page 

#Scenario: View products through Spend and Save link

#Given Open the chrome browser and visit the homepage
#When User click to accept cookie and User navigates to the Spend and Save link and click
#Then User should be able to view Products and prices

Feature: Open Aspirations home page and products page 

Scenario: View products through Spend and Save link

Given Open the chrome browser and visit the homepage
When User click to accept cookie
And User navigates to the Spend and Save link and click
Then User should be able to view Products and prices
