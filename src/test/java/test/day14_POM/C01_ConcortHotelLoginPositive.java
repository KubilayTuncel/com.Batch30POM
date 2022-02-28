package test.day14_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive  extends TestBase {

    @Test
    public void positiveLoginTest(){
        //https://www.concorthotel.com/ adresine git
        //login butonuna bas
        //test data username: manager ,
        //test data password : Manager1!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotel = new ConcortHotelPage(driver);
        concortHotel.logIn.click();
        concortHotel.userName.sendKeys("manager");
        concortHotel.password.sendKeys("Manager1!");
        concortHotel.enterButonu.click();
        Assert.assertTrue(concortHotel.basariliGirisYaziElementi.isDisplayed());
    }
    @Test
    public void negativeLoginTest(){
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotel = new ConcortHotelPage(driver);
        concortHotel.logIn.click();
        concortHotel.userName.sendKeys("manager");
        concortHotel.password.sendKeys("Manager1");
        concortHotel.enterButonu.click();
        Assert.assertTrue(concortHotel.isLoginFailed.isDisplayed());
    }
}
