@smoke @chrome
Feature: Chrome Automation Tests

  @links
  Scenario: Chrome - W3 Bad Page - Links Test
    Given the user opens "chrome" browser and navigates to the "bad" page
    Then the page response code should be 404
    And all links on the page should redirect to a valid page

  @links
  Scenario: Chrome - W3 Multi-Modal Page - Links Test
    Given the user opens "chrome" browser and navigates to the "multi-modal" page
    Then the page response code should be 200
    And all links on the page should redirect to a valid page

  @links
  Scenario: Chrome - W3 HTML/CSS Page - Links Test
    Given the user opens "chrome" browser and navigates to the "html css" page
    Then the page response code should be 200
    And all links on the page should redirect to a valid page

  @logs
  Scenario: Chrome - W3 Bad Page - Console Logs Test
    Given the user opens "chrome" browser and navigates to the "bad" page
    Then the page response code should be 404
    And the console log should have no errors after page load

  @logs
  Scenario: Chrome - W3 Multi-Modal Page - Console Logs Test
    Given the user opens "chrome" browser and navigates to the "multi-modal" page
    Then the page response code should be 200
    And the console log should have no errors after page load

  @logs
  Scenario: Chrome - W3 HTML/CSS Page - Console Logs Test
    Given the user opens "chrome" browser and navigates to the "html css" page
    Then the page response code should be 200
    And the console log should have no errors after page load
