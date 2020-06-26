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
@feature
Feature: Validating Extent Report
  I want to use this template for my feature file


@tag  @all
  Scenario Outline: Scenario 1 <name>
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

@regression
    Examples: 
      | name  | value | status  |
      | "Test 1" |     5 | "success" |
      | "Test 2" |     7 | "Fail"    |
 
@data  
   	Examples: 
      | name  | value | status  |
      | "Test 3" |     9 | "success" |
      | "Test 4" |     10 | "Fail"    |
      
@different
   Scenario: Scenario 2
    Given I want to write a step with "Rubesh"
    When I check for the title in step
    | title                                |
    | The Devil in the White City          |
    | The Lion, the Witch and the Wardrobe |
    Then I verify the "Success" in step
  
