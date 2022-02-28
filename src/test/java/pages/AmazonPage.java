package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    //bir  page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey bir constructor olusturup
    //driver'a ilk degeri atamaktir (instantiote)
    public AmazonPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    public WebElement dropDown;

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath ="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement ilkUrun;
}
