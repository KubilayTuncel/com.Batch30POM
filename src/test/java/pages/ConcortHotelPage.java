package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;
    public ConcortHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[text()='Log in']")
    public WebElement logIn;

    @FindBy (xpath = "//input[@class='form-control required']")
    public WebElement userName;

    @FindBy (xpath = "//input[@class='form-control required password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement enterButonu;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;
}
