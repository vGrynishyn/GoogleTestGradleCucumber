package googleTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import googleTest.pages.HomePage;
import googleTest.pages.SearchResPage;
import googleTest.utils.Browser;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Stepdefs extends BasePage{

    private HomePage homePage = new HomePage();
    private SearchResPage searchPage = new SearchResPage();
    private static final String URL = "https://www.google.com.ua/";
    private static final String PATTERN = "automation";
    private static final String EXPECTED_DOMAIN_NAME = "home-assistan";

    @FindBy(css = "input[name=q]")
    private WebElement searchInput;

    @Given("I go to google.com")
    public void i_go_to_google_com() {
        // Write code here that turns the phrase above into concrete actions
        browser.openWebPage(URL);
    }

    @Then("I search word 'automation'")
    public void i_search_word_automation() {
        searchInput.sendKeys(PATTERN + Keys.ENTER);
    }

   @Then("I look for expected word in search results")
    public void i_look_for_expected_word_in_search_results() {
       new SearchResPage().clickFirstSearchResultLinks();
       Assert.assertTrue("Browser title not contain expected result.", browser.getTitle().contains("automation"));
    }

    @Then("I look for domain on next 5 pages")
    public void i_look_for_domain_on_next_5_pages(){
        String actualLink = searchPage
                .getSearchLinkFromResults(EXPECTED_DOMAIN_NAME, 5);
        Assert.assertTrue("There is not found expected domain name(page:1-5).", actualLink.contains(EXPECTED_DOMAIN_NAME));
    }
}
