package test.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {
    //Bir test method olustur positiveLoginTest()
    // https://qa-environment.concorthotel.com/ adresine git
    // login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.logIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.enterButonu.click();
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

}
