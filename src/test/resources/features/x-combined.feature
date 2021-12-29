#@smoke
#Feature: Chrome + Firefox - Automation Tests - Consolidated validation tests for each page
#
#  @badpage
#  Scenario: Chrome - W3 Bad Page Test
#    Given the user opens "chrome" browser and navigates to the "bad" page
#    Then the page response code should be 404
#    And all links on the page should redirect to a valid page
#    And the console log should have no errors after page load
#
#  @mutlimodal
#  Scenario: Chrome - W3 Multi-Modal Page Test
#    Given the user opens "chrome" browser and navigates to the "multi-modal" page
#    Then the page response code should be 200
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page
#
#  @htmlcss
#  Scenario: Chrome - W3 HTML/CSS Page Test
#    Given the user opens "chrome" browser and navigates to the "html css" page
#    Then the page response code should be 200
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page
#
#
#  # TODO: *** FIREFOX - NEED TO FIX FETCHING BROWSER CONSOLE LOGS. TEMP TRY/CATCH WORKAROUND ***
#  @badpage
#  Scenario: Firefox - W3 Bad Page Test
#    Given the user opens "firefox" browser and navigates to the "bad" page
#    Then the page response code should be 404
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page
#
#  @mutlimodal
#  Scenario: Firefox - W3 Multi-Modal Page Test
#    Given the user opens "firefox" browser and navigates to the "multi-modal" page
#    Then the page response code should be 200
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page
#
#  @htmlcss
#  Scenario: Firefox - W3 HTML/CSS Page Test
#    Given the user opens "firefox" browser and navigates to the "html css" page
#    Then the page response code should be 200
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page
#
#
#  @browserconfig
#  Scenario: Browser Set From Config File - Extra W3 Multi-Modal Test
#    Given the user is on the "multi-modal" page
#    Then the page response code should be 200
#    And the console log should have no errors after page load
#    And all links on the page should redirect to a valid page