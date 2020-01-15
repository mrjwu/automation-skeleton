Feature: Some SPA

  Scenario Outline: Go to the SPA Keyboard Sample Form
    Given user is already on Home Page
    When title of login page is ToolsQA
    Then user goes to  Keyboard Sample Form
    Then user enters <userName>, <currentAddress>, <permanentAddress> fillers

    Examples:
      | userName | currentAddress | permanentAddress |
      | King | John | Third |
      | Lady | Sansa | Stark |