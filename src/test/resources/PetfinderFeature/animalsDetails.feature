Feature: Animal Details

  @api
  Scenario Outline: Retrieve animal details by ID
    Given base URI is <URI>
    And animal ID is <animalID>
    And authorization token
    When GET request is sent with the animal ID
    Then response contains information about the animal with the specified ID
    Examples:
      | URI                                   | animalID |
      | https://api.petfinder.com/v2/animals/ | 63028994 |