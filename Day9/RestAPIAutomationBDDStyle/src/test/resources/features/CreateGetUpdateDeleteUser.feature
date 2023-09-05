# Author: tester@xyz.com
Feature: Create Get Update and Delete user API Automation Scenarios

  Scenario: Test the Create User API
    Given Create user payload details "John Smith" "male" "john.smith1@15ce.com" "active"
    When User calls CreateUser API using POST method
    Then The POST API call got success with status code 201
    And email in the Post response is "john.smith1@15ce.com"
