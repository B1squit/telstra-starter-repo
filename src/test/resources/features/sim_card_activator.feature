Feature: Is sim card activated correctly?
    Sim card will be need to be activated and added to database

    Scenario: Sim card iccid is valid and activated
        Given the sim card iccid "1255789453849037777" is valid
        And that it is activated through "activate" 
        When I query "getSimCard" with id "1"
        Then the sim card should be activated
        
    Scenario: Sim card iccid is not valid and not activated
        Given the sim card iccid "8944500102198304826" is not valid
        And that it is activated through "activate" 
        When I query "getSimCard" with id "2"
        Then the sim card should not be activated
        