package test.day14_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_AmazonConfiReader extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("arananKelime")+ Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains(ConfigReader.getProperty("arananKelime")));
    }
}
