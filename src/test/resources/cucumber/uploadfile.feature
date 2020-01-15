Feature: Upload File

  Scenario Outline: Choose a file and upload successfully
    Given user goes to Home Page
    And goes to Upload Page
    When user chooses <file>
    Then clicks on upload button

    Examples:
      | file |
      | pdf-test.pdf |
      | doc-test.doc |