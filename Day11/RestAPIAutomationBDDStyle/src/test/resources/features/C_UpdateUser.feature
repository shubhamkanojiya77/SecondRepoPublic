#Author: your.email@your.domain.com
Feature: Go Rest Update User API Test Scenario

	@UpdateUser
  Scenario: Test the Update User API
    Given User has userID of already created user
    And "Update" user payload details "John Abraham" "male" "john.ab1@15ce.com" "active"
    When User calls "UpdateUser" API using "PUT" method
    Then The "PUT" API call got success with status code 200
    And "name" in the "Put" response is "John Abraham"
    And "gender" in the "Put" response is "male"
    And "email" in the "Put" response is "john.ab1@15ce.com"
    And "status" in the "Put" response is "active"