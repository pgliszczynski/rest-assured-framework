Feature: Validating Place APIs

  @AddPlace
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" HTTP request
    Then The response returns status code 200
    And "status" is "OK"
    And verify place_id created maps to "<name>" using "GetPlaceAPI"
    Examples:
      | name    | language | address            |
      | AAhouse | English  | World cross center |
      | BBHouse | French   | Addres line 1      |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given Delete Place Payload
    When User calls "DeletePlaceApi" with "DELETE" HTTP request
    Then The response returns status code 200
    And "status" is "OK"