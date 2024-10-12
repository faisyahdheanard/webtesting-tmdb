package steps;

import config.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.moviePage;
import pages.profilePage;

public class markAsFavoriteStep extends base {
    homePage HomePage;
    commonStep CommonStep;
    profilePage ProfilePage;
    moviePage MoviePage;

    @Given("Open the web app")
    public void openTheWebApp() {
        getDriver();
        HomePage = new homePage(driver);
        HomePage.navigateToTheWeb();
        HomePage.verifyOnHomePage();
    }

    @And("User is not logged in")
    public void userIsNotLoggedIn() {
    }


    @And("User is logged in")
    public void userIsLoggedIn() {
        HomePage.clickLoginButton();
        CommonStep = new commonStep(driver);
        CommonStep.loginUser();
        ProfilePage = new profilePage(driver);
        ProfilePage.verifyOnProfilePage();
        HomePage.clickHomeButton();
    }

    @When("Click the language icon")
    public void clickTheLanguageIcon() {
        HomePage.clickLanguageIcon();
    }

    @And("Select {string} in the default language option")
    public void selectInTheDefaultLanguageOption(String language) throws InterruptedException {
        HomePage.selectLanguage(language);
    }

    @And("Click the Reload Page button")
    public void clickReloadPageButton() throws InterruptedException {
        HomePage.clickReloadPageButton();
    }

    @Then("Interface changes to {string} language")
    public void interfaceChangesToLanguage(String language) throws InterruptedException {
        HomePage.verifyInterfaceLanguage(language);
        quitDriver();
    }

    @When("Search for {string} using the search bar")
    public void searchForUsingTheSearchBar(String movie) {
        HomePage.searchMovie(movie);
    }

    @And("Click the Search button")
    public void clickTheSearchButton() {
        HomePage.clickSearchButton();
    }

    @And("Click on {string} movie title")
    public void clickOnMovieTitle(String movie) {
        HomePage.clickMovieTitle(movie);
    }

    @And("A pop-up alert appears stating {string}")
    public void aPopUpAlertAppearsStating(String alert) {
        MoviePage = new moviePage(driver);
        MoviePage.verifyAlertIsPresent(alert);
        quitDriver();
    }

    @Then("The Heart icon changes to a filled color")
    public void theHeartIconChangesToAFilledColor() throws InterruptedException {
        MoviePage.verifyHeartIconFilledColor();
    }

    @And("Click the Heart icon")
    public void clickTheHeartIcon() {
        MoviePage = new moviePage(driver);
        MoviePage.clickHeartIcon();
    }

    @And("{string} will be included in the {string} list page")
    public void willBeIncludedInTheMyFavoritesListPage(String movie, String word) throws InterruptedException {
        ProfilePage.verifyOnMyFavoritePage(word);
        ProfilePage.verifyMovieIsOnTheList(movie);
        CommonStep = new commonStep(driver);
        CommonStep.deleteAllMoviesFromFavorite();
        quitDriver();
    }

    @When("Navigate to the {string} {string} list page through {string}")
    public void navigateToTheMyFavoriteListPage(String word, String word2, String word3) throws InterruptedException {
        HomePage.navigateToProfilePage(word3);
        ProfilePage = new profilePage(driver);
        ProfilePage.verifyOnProfilePage();
        ProfilePage.navigateToMyFavoriteMovieList(word, word2);
    }

    @And("{string} is marked as favorite movies")
    public void isMarkedAsFavoriteMovies(String arg0) {
    }

    @When("Click the Remove button")
    public void clickTheRemoveButton() {
    }

    @Then("{string} is removed from the My favorites list")
    public void isRemovedFromTheMyFavoritesList(String arg0) {
    }

    @When("User applies the filter by <case> in <order> order")
    public void userAppliesTheFilterByCaseInOrderOrder() {
    }

    @Then("The movies in the My Favorites list should be sorted by <case> in <order> order")
    public void theMoviesInTheMyFavoritesListShouldBeSortedByCaseInOrderOrder() {
    }

    @And("Using {string} as default language")
    public void usingAsDefaultLanguage(String language) throws InterruptedException {
        CommonStep = new commonStep(driver);
        CommonStep.setDefaultLanguage(language);
    }
}
