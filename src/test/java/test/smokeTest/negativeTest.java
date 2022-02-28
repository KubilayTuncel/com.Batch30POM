package test.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {
    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    // - yanlisSifre
    // - yanlisKulllanici
    // - yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1!
    //2) https://qa-environment.concorthotel.com/ adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
    QAConcortPage qaConcortPage;

    @Test (priority = -1, groups = "birinciGrup")
    public void yanlisSifre(){

        qaConcortPage=new QAConcortPage();
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage.logIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.enterButonu.click();
        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());
    }

    @Test (dependsOnMethods = "yanlisSifre", groups = "birinciGrup")
    public void yanlisKullanici(){
        qaConcortPage = new QAConcortPage();
        qaConcortPage.userName.clear();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidusername"));
        qaConcortPage.password.clear();
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.enterButonu.click();
        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());
    }

    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisSifreKullanici(){
        qaConcortPage = new QAConcortPage();
        qaConcortPage.userName.clear();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidusername"));
        qaConcortPage.password.clear();
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.enterButonu.click();
        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());
        Driver.closeDriver();
    }
}
