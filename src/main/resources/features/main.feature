Feature: Google Text Search


Scenario: Doing Google Text Search
    Given Google in Open in Browser    
    When I search for "Facebook"
    Then I can see "Welcome to Facebook - Log In, Sign Up or Learn More" link in search result

Scenario: Doing Google Text Search
    Given Google in Open in Browser    
    When I search for "Facebook" image
    Then I can see facebook image in search result
    