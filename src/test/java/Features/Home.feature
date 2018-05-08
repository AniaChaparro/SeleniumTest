Feature: RS Technical Test

Scenario: Search items from the Home page
  Given a RSComponent super web page
  When a user searches for a Glass Battery Hydrometer
  Then the page title is Glass Battery Hydrometer

  Scenario: Search invalid item from the Home page
    Given a RSComponent super web page
    When a user searches for a Fancy Item
    Then a warning message We couldn't find any results for 'Fancy Item' is shown

  Scenario: Search without specifying an item from the Home page
    Given a RSComponent super web page
    When a user searches without specifying an item
    Then a popup error message is shown

  Scenario: Purchase item end to end
    Given a RSComponent super web page
    When a user searches for a Glass Battery Hydrometer
    And a user adds the item to the basket
    Then the Glass Battery Hydrometer is added to the basket

  Scenario: Purchase 2 items end to end
    Given a RSComponent super web page
    When a user searches for a Glass Battery Hydrometer
    And a user increments the item quantity to two
    And a user adds the item to the basket
    Then the Glass Battery Hydrometer is added to the basket
    And the quantity is 2