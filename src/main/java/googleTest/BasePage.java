package googleTest;

import googleTest.utils.Browser;
import org.openqa.selenium.support.PageFactory;

import static googleTest.utils.Driver.getWebDriver;

public abstract class BasePage {

    protected static Browser browser = new Browser();

    public BasePage(){
        PageFactory.initElements(getWebDriver(), this);
    }

}
