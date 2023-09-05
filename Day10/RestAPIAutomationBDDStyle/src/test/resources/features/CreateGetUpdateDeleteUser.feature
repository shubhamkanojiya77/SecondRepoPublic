# Author: tester@xyz.com
Feature: Create Get Update and Delete user API Automation Scenarios

  Scenario: Test the Create User API
    Given "Create" user payload details "John Smith" "male" "john.smith11@15ce.com" "active"
    When User calls "CreateUser" API using "POST" method
    Then The "POST" API call got success with status code 201
    And "email" in the "Post" response is "john.smith11@15ce.com"

  Scenario: Test the Get User API
    Given User has userID of already created user
    When User calls "GetUser" API using "GET" method
    Then The "GET" API call got success with status code 200
    And "name" in the "Get" response is "John Smith"
    And "gender" in the "Get" response is "male"
    And "email" in the "Get" response is "john.smith11@15ce.com"
    And "status" in the "Get" response is "active"

  Scenario: Test the Update User API
    Given User has userID of already created user
    And "Update" user payload details "John Abraham" "male" "john.ab1@15ce.com" "active"
    When User calls "UpdateUser" API using "PUT" method
    Then The "PUT" API call got success with status code 200
    And "name" in the "Put" response is "John Abraham"
    And "gender" in the "Put" response is "male"
    And "email" in the "Put" response is "john.ab1@15ce.com"
    And "status" in the "Put" response is "active"
    
    Scenario: Test the Delete User API
    Given User has userID of already created user    
    When User calls "DeleteUser" API using "DELETE" method
    Then The "DELETE" API call got success with status code 204
