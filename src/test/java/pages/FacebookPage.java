package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")
        public WebElement cookies;

        @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
        public WebElement userName;

        @FindBy(xpath = "//input[@type='password']")
        public WebElement password;

        @FindBy (xpath = "//div[@class='_9ay7']")
        public WebElement alertYazisiElementi;

}
