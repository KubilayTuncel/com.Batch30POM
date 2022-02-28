package test.day14_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C02_ConfigReader extends TestBase {

    @Test
    public void positiveTest() {
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage =new ConcortHotelPage(driver);
        concortHotelPage.logIn.click();
        concortHotelPage.userName.sendKeys(ConfigReader.getProperty("CHValidusername"));
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.enterButonu.click();
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());
    }

    @Test
    public void negativeTest(){
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.logIn.click();
        concortHotelPage.userName.sendKeys(ConfigReader.getProperty("CHInvalidusername"));
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.enterButonu.click();
        Assert.assertTrue(concortHotelPage.isLoginFailed.isDisplayed());
    }
}
