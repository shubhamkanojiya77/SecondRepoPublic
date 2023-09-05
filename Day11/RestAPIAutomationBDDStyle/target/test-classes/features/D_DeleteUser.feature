# Author: tester@xyz.com
Feature: Go Rest Delete User API Automation Scenarios

	@DeleteUser
  Scenario: Test the Delete User API
    Given User has userID of already created user
    When User calls "DeleteUser" API using "DELETE" method
    Then The "DELETE" API call got success with status code 204
