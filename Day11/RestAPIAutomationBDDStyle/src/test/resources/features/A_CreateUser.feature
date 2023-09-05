#Author: your.email@your.domain.com
Feature: Go Rest Create User API Test Scenarios

	@CreateUser
  Scenario: Test the Create User API
    Given "Create" user payload details "John Smith" "male" "john.smith11@15ce.com" "active"
    When User calls "CreateUser" API using "POST" method
    Then The "POST" API call got success with status code 201
    And "email" in the "Post" response is "john.smith11@15ce.com"