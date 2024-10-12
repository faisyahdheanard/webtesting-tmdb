Feature: Mark as Favorite Functionality with English Language

    Background:
      Given Open the web app

    Scenario: Mark a movie as favorite when user not logged in
      Given User is not logged in
      When Click the Search button
      And Search for "Despicable Me 4" using the search bar
      And Click on "Despicable Me 4" movie title
      And Click the Heart icon
      And A pop-up alert appears stating "Login to add this movie to your favorite list"

    Scenario: Mark a movie as favorite when user logged in
      And User is logged in
      And Using "Inggris" as default language
      When Click the Search button
      And Search for "Despicable Me 4" using the search bar
      And Click on "Despicable Me 4" movie title
      And Click the Heart icon
      Then The Heart icon changes to a filled color
      When Navigate to the "Favorites" "Movie" list page through "View profile"
      And "Despicable Me 4" will be included in the "My Favorites" list page

#  Scenario: Ensure the movie is saved in the user's 'My Favorite' profile page
#    And User is logged in
#    When Search for "Despicable Me 4" using the search bar
#    And Click the Search button
#    And Click on "Despicable Me 4" movie title
#    And Click the Heart icon
#    Then The Heart icon changes to a filled color
#    When Navigate to the "Favorites" "Movie" list page through "View profile"
#    And "Despicable Me 4" will be included in the "My Favorites" list page
#
#  Scenario: Mark multiple movies as favorite
#    And User is logged in
#    When Search for "Despicable Me 4" using the search bar
#    And Click the Search button
#    And Click on "Despicable Me 4" movie title
#    And Click the Heart icon
#    Then The Heart icon changes to a filled color
#    When Search for "Disclaimer" using the search bar
#    And Click the Search button
#    And Click on "Disclaimer" movie title
#    And Click the Heart icon
#    Then The Heart icon changes to a filled color
#    When Navigate to the "Favorites" "Movie" list page through "View profile"
#    Then "Despicable Me 4" will be included in the "My Favorite" list page
#    And "Disclaimer" will be included in the "My Favorite" list page
#
#  Scenario: Remove movie from favorite list
#    And User is logged in
#    And "Despicable Me 4" is marked as favorite movies
#    When Navigate to the "Favorites" "Movie" list page through "View profile"
#    When Click the Remove button
#    Then "Despicable Me 4" is removed from the "My Favorite" list
#
#  Scenario Outline: Filter favorite movies by <case> in <order> order
#    And User is logged in
#    And "Despicable Me 4" is marked as favorite movies
#    And "Disclaimer" is marked as favorite movies
#    When Navigate to the "Favorites" "Movie" list page through "View profile"
#    When User applies the filter by <case> in <order> order
#    Then The movies in the "My Favorite" list should be sorted by <case> in <order> order
#
#    Examples:
#      | case          | order        |
#      | release date  | ascending    |
#      | release date  | descending   |
#      | date added    | ascending    |
#      | date added    | descending   |
#      | popularity    | ascending    |
#      | popularity    | descending   |
