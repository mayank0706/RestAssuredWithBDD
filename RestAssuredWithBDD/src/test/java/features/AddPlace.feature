#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Validating the Place API

  Scenario Outline: Validating the Add Place API
    Given add place api payload with "<name>" "<address>" "<website>" "<language>"
    When user sends "AddPlaceResource" with the "post" request
    Then status code is 200
    And "status" in response body is "OK"
    
    Examples:
    | name          |  address          | website       | language     |
    |Regenta Suites |Church Street NY   |www.google.com |Espanol es_ES |
    |Masion Retreat |Broadway Street NC |www.google.com |French fr_FR  |
