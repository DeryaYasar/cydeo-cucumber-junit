Feature: Examples of Cucumber data tables implementations


  Scenario: List of fruits I like
    Then user should see fruits I like
      | Kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |

    #to beautify the pipes above (|| bunların hepsini aynı hizaya sokma)
  #mac: command + option + L
  #windows: control + alt + L


  @wip
  Scenario: User should be able to see all 12 months in months
  dropdown

    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |
