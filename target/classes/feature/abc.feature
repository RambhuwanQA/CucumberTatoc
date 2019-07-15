Feature: User is able to complete basic course 
Scenario: user should able to navigate on basic course

Given user is on home page			
When user click on basic course		
And click on green
And user is on repaint page and click on repaint untill color matches
And click on dragMe
And user is on popup Page
Then user is on complete  page


