import googleTest.BasePage;
import googleTest.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * @author vGrynishyn
 * @since 31/09/2017
 */

@RunWith(value = Parameterized.class)
public class GoogleTestCucumber extends BasePage {

    private HomePage homePage = new HomePage();
    private static final String URL = "https://www.google.com.ua/";
    private static final String PATTERN = "automation";
    private static final String EXPECTED_DOMAIN_NAME = "testautomationday.com";

    private  String pattern;
    private  String expectedDomainName;

    public GoogleTestCucumber(String pattern, String expectedDomainName) {
        this.pattern = PATTERN;
        this.expectedDomainName = EXPECTED_DOMAIN_NAME;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{PATTERN, EXPECTED_DOMAIN_NAME}};
        return Arrays.asList(data);
    }

    @After
    public void afterTest() {
        browser.closeBrowser();
    }

    @Test
    public void searchPatternAndCheckBrowserTitleTest() {
        homePage
                .openWebPage(URL)
                .searchPattern(pattern)
                .clickNeededNumOfResultLinks(0);
        Assert.assertTrue("Expacted pattern doesnot find", browser.getTitle().contains(pattern));
    }

    @Test
//    @Parameters({"pattern", "pagesNum", "expectedDomainName"})
//    public void tryToFindExpectedDomainNameTest(@Optional(PATTERN) String pattern, @Optional("5") int pagesNum, @Optional(EXPECTED_DOMAIN_NAME) String expectedDomainName) {
    public void tryToFindExpectedDomainNameTest() {
        String actualLink = homePage
                .openWebPage(URL)
                .searchPattern(pattern)
                .getSearchLinkFromResults(expectedDomainName, 5);
        Assert.assertTrue("There is not found expected domain name(page:1-5).", actualLink.contains(expectedDomainName));
    }

//    @Test(dataProvider = "foundLinks")
//    @Parameters("linkText")
//    public void checkIfGoogleSearchCanFindTestAutomationDayDomainTest(String foundLink) {
//        LogInformation.info(String.format("Verify expected domain name '%s' is present in %s.", EXPECTED_DOMAIN_NAME, foundLink));
//        Assert.assertTrue(String.format("Could not find expected domain name '%s' in '%s' link.", EXPECTED_DOMAIN_NAME, foundLink), foundLink.contains(EXPECTED_DOMAIN_NAME));
//    }
//
//    @DataProvider(name = "foundLinks", parallel = true)
//    public Object[][] getLinks() {
//        ArrayList<String> links = homePage
//                .openWebPage(URL)
//                .searchPattern(PATTERN + "day")
//                .getResultLinks();
//        Collection<Object[]> data = new ArrayList();
//        links.forEach(item -> data.add(new Object[]{item}));
//        Browser.closeBrowser();
//        return (Object[][]) links.toArray();
//    }
}
