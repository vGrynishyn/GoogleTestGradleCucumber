package googleTest.pages;

import googleTest.BasePage;
import googleTest.utils.Browser;
import googleTest.utils.LogInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResPage extends BasePage {

//    private Browser browser = new Browser();
    @FindBy(className = "cur")
    private WebElement numberOfCurrentPage;
    @FindBy(xpath = "//*[@class='r']/a[@href]")
    private List<WebElement> resultWebElement;
    @FindBy(css = ".rc .r div cite")
    private List<WebElement> resultUrls;
    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    /**
     * Search for webelements of search result title for click
     */
    private ArrayList<WebElement> getSearcResultWebElements(){
        ArrayList<WebElement> webElements = new ArrayList<>();
        for (WebElement element: resultWebElement){
            webElements.add(element);
        }
        return webElements;
    }

    /**
     * Click needed position on result page
     * @param position
     */
    public void clickNeededNumOfResultLinks(int position){
        getSearcResultWebElements().get(position).click();
    }

    public void clickFirstSearchResultLinks(){
        getSearcResultWebElements().get(0).click();
    }

    /**
     * Search for the expected template (domain name) in results search link on numOfSearchPage  googleTest.pages
     * @param expectedDomainName
     * @param numOfSearchPage
     * @return
     */
    public String getSearchLinkFromResults(String expectedDomainName, int numOfSearchPage){
        LogInformation.info(String.format("Search %s link on search results googleTest.pages(page: 1-5).",expectedDomainName));
        while(Integer.valueOf(numberOfCurrentPage.getText()) < numOfSearchPage)
        {
            ArrayList<String> actualDomainName = getResultLinks();
            List<String> expectedDomainNameList = actualDomainName.stream().filter(r -> r.contains(expectedDomainName)).collect(Collectors.toList());
            if(expectedDomainNameList.size() > 0)
                    return expectedDomainNameList.get(0);
            clickToNextPage();
        }
        return "";
    }

    /**
     * Click next page
     */
    private void clickToNextPage(){
        LogInformation.info("Click to next page.");
        browser.scrollToElement(nextPageButton);
        nextPageButton.click();
    }


    /**
     * Search for result links
     */
    public ArrayList<String> getResultLinks() {
        LogInformation.info("Get searched links.");
        ArrayList<String> links = new ArrayList();
        for (WebElement element : resultUrls) {
            links.add(element.getText());
        }
        return links;
    }
}
