#Author: your.email@your.domain.com

Feature: Go Rest Get User API Test Scenarios

	@GetUser
  Scenario: Test the Get User API
    Given User has userID of already created user
    When User calls "GetUser" API using "GET" method
    Then The "GET" API call got success with status code 200
    And "name" in the "Get" response is "John Smith"
    And "gender" in the "Get" response is "male"
    And "email" in the "Get" response is "john.smith11@15ce.com"
    And "status" in the "Get" response is "active"
