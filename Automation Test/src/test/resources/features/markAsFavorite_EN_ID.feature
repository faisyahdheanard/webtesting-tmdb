Feature: Mark as Favorite Functionality with Indonesian Language

    Background:
      Given Open the web app

    Scenario Outline: Change language to Indonesian based on user <case> condition
      And User is <case>
      When Click the language icon
      And Select "Indonesian" in the default language option
      And Click the Reload Page button
      Then Interface changes to "Indonesian" language

      Examples:
        | case          |
        | not logged in |
        | logged in     |

    Scenario: Mark a movie as favorite when user not logged in
      Given User is not logged in
      And Using "Indonesian" as default language
      When Click the Search button
      And Search for "Despicable Me 4" using the search bar
      And Click on "Despicable Me 4" movie title
      And Click the Heart icon
      And A pop-up alert appears stating "Masuk untuk menambahkan film ke daftar sukaan anda"

    Scenario: Mark a movie as favorite when user logged in
      And User is logged in
      When Click the Search button
      And Search for "Despicable Me 4" using the search bar
      And Click on "Despicable Me 4" movie title
      And Click the Heart icon
      Then The Heart icon changes to a filled color
      When Navigate to the "Paling Disuka" "Film" list page through "Lihat Profil"
      Then "Despicable Me 4" will be included in the "Favorit Saya" list page

#  Scenario: Ensure the movie is saved in the user's 'My Favorite' profile page
#    And User is logged in
#    When Search for "Despicable Me 4" using the search bar
#    And Click the Search button
#    And Click on "Despicable Me 4" movie title
#    And Click the Heart icon
#    Then The Heart icon changes to a filled color
#    When Navigate to the "Paling Disuka" "Film" list page through "Lihat Profil"
#    And "Despicable Me 4" will be included in the "Favorit Saya" list page
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
#    When Navigate to the "Paling Disuka" "Film" list page through "Lihat Profil"
#    Then "Despicable Me 4" will be included in the "Favorit Saya" list page
#    And "Disclaimer" will be included in the "Favorit Saya" list page
#
#  Scenario: Remove movie from favorite list
#    And User is logged in
#    And "Despicable Me 4" is marked as favorite movies
#    When Navigate to the "Paling Disuka" "Film" list page through "Lihat Profil"
#    When Click the Remove button
#    Then "Despicable Me 4" is removed from the "Favorit Saya" list
#
#  Scenario Outline: Filter favorite movies by <case> in <order> order
#    And User is logged in
#    And "Despicable Me 4" is marked as favorite movies
#    And "Disclaimer" is marked as favorite movies
#    When Navigate to the "Paling Disuka" "Film" list page through "Lihat Profil"
#    When User applies the filter by <case> in <order> order
#    Then The movies in the "Favorit Saya" list should be sorted by <case> in <order> order
#
#    Examples:
#      | case          | order        |
#      | release date  | ascending    |
#      | release date  | descending   |
#      | date added    | ascending    |
#      | date added    | descending   |
#      | popularity    | ascending    |
#      | popularity    | descending   |
