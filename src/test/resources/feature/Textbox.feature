Feature: Check function TextBox

  Background:
    Given I open chrome
    When I connect to website with link "https://www.seleniumeasy.com/test/"
    And I turn off Popup
    And Move to textbox page with main menu "Input Forms" and sub menu "Simple Form Demo"

  @textbox_01
  Scenario Outline: Input text with String value
    When I input with below "<value>"
    And I click button show messenger
    Then The respone return should be like "<value>"
    And I close browser
    Examples:
      | value |
      | oke   |
      | aok a |
      | 1     |