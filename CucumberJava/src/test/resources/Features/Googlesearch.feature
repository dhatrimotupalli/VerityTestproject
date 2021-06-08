# Author : dhatri.motupalli@gmail.com
# Date   : 8-Jun-2021
# Description : The sample feature is created for automating Google search engine results based on keywords passed
@Tags
Feature: To test Google Search functionality

  @Software
  Scenario: Validate whether Wikipedia link is returned as the first result when user searches with 'Software' keyword on google search.
    Given browser is open
    And user is on google search page
    When user enters software as a keyword on search textbox
    And user click on search button or hits enter
    Then user should be navigated to search results page viewing Wikipedia link as the first result
