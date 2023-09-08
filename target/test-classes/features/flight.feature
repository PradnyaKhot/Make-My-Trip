@Flight
Feature: Validate the flight booking page

@Onewaytrip
Scenario: User selects a one-way trip

Given the user is on the flight booking page 
When enters the Departure City
|Mumbai|
And enters the Destination City
|Delhi|
And selects the Departure Date
|2023-December-01|
And clicks on the Search button
Then the user should see a list of available one-way flights
    

@Booking
Scenario: User chooses the convinient flight

Given  user is on flight search result page
When user chooses flight with fewest stops
And chooses airlines type
And clicks on View Prices button
And clicks on Book Now button
Then user is taken to passenger details page    


@Valid
Scenario: User adds the traveller details for valid data

Given the user is on passenger details page
When user chooses trip security option
And user opens an excel sheet and read the values
And user clicks on add adult 
And user enters first name 
And user enters last name
And user selects gender
And user enters contact number
And user enters mail id
And user confirms all details
Then user is taken to continue booking page


@Invalid
Scenario Outline: User adds the traveller details for invalid data

Given the user is on passenger detail page
When user chooses trip insurance
And user enters contact number as <contact>
And user enters mail id as <mail>
Then error message should be displayed

Examples:
|contact   |mail        |
|89765430df|vbggmail.com|


@Completion
Scenario: User completes the booking

Given User is on seat booking page
When Confirms the seat number
And Clicks on cotinue button
And Selects baggage free travelling
And Proceeds to pay
Then User is taken to payment page