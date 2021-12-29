@smoke @firefox
Feature: Firefox Automation Tests

  @links
  Scenario: Firefox - W3 Bad Page - Links Test
    Given the user opens "firefox" browser and navigates to the "bad" page
    Then the page response code should be 404
    And all links on the page should redirect to a valid page

  @links
  Scenario: Firefox - W3 Multi-Modal Page - Links Test
    Given the user opens "firefox" browser and navigates to the "multi-modal" page
    Then the page response code should be 200
    And all links on the page should redirect to a valid page

  @links
  Scenario: Firefox - W3 HTML/CSS Page - Links Test
    Given the user opens "firefox" browser and navigates to the "html css" page
    Then the page response code should be 200
    And all links on the page should redirect to a valid page

  # TODO: *** FIREFOX - NEED TO FIX FETCHING BROWSER CONSOLE LOGS. TEMP TRY/CATCH WORKAROUND ***
  @logs
  Scenario: Firefox - W3 Bad Page - Console Logs Test
    Given the user opens "firefox" browser and navigates to the "bad" page
    Then the page response code should be 404
    And the console log should have no errors after page load

  @logs
  Scenario: Firefox - W3 Multi-Modal Page - Console Logs Test
    Given the user opens "firefox" browser and navigates to the "multi-modal" page
    Then the page response code should be 200
    And the console log should have no errors after page load

  @logs
  Scenario: Firefox - W3 HTML/CSS Page - Console Logs Test
    Given the user opens "firefox" browser and navigates to the "html css" page
    Then the page response code should be 200
    And the console log should have no errors after page load
