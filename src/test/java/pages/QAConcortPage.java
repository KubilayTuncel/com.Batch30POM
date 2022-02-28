package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {
    public WebDriver driver;

    public QAConcortPage(){

        PageFactory.initElements(Driver.getDriver(),this);
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

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public  WebElement hotelManage;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public  WebElement hotelList;

    @FindBy (xpath = "//a[@class='btn btn-circle btn-default']")
    public  WebElement addHotel;

    @FindBy (xpath = "//input[@id='Code']")
    public WebElement code;

    @FindBy (xpath = "//select[@class='form-control input-lg required']")
    public WebElement dropDown;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement kaydedildiYazisi;

    @FindBy (xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoom;

    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoom;

    @FindBy (xpath = "//select[@id='IDHotel']")
    public WebElement addRoomIdDropDown;

    @FindBy (xpath = "//select[@id='IDGroupRoomType']")
    public  WebElement roomTypeDropDown;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement clickButonu;

    @FindBy (xpath = "//a[text()='Hotelrooms']")
    public WebElement addRoomHome;

    @FindBy (xpath = "//span[text()='List Of Hotelrooms']")
    public  WebElement addRoomListYazisi;

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> satirlarListesi;

    @FindBy (xpath = "//tbody/tr[1]")
    public WebElement ilkSatir;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;

    public void LoginMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        logIn.click();
        userName.sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        enterButonu.click();
    }

    public String printData (int satir, int sutun){
        //ornekteki haliyle 3. satir, 5.sutundaki elemani yazdiralim
        // String xpath = //tbody//tr[3]//td[5]
        //degismeyecek kisimlari String, degismeyecek ksimlari ise parametre ismi olarak yazdik
        String xpath="//tbody//tr["+satir+"]//td["+sutun+"]";

        //satir no 3, sutun no 5
        //System.out.println("satir no :"+ satir+" sutun no : "+sutun);

        //@FindBy notasyonu parametreli calismadigi icin onceki yontem ile locate edelim
        String istenenData= Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no :"+ satir+", sutun no : "+sutun+"'deki data : "+istenenData);

        return istenenData;
    }
}
