Feature: Animal Search

  @api
  Scenario Outline: Retrieve animals by type and location
    Given base URI is <URI>
    And type is <animalType>
    And location is <location>
    And authorization token
    When GET request is sent
    Then response status code is <statusCode>
    And response format is JSON
    And response contains all requested fields
    And response contains a list with <animalType>
    And from <location>
    Examples:
      | URI                                      | animalType | location | statusCode |
      | https://www.petfinder.com/api/v2/animals | dog        | New York | 200        |