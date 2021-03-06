package test.day25;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPagePOM;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderIleTest {

    @DataProvider
    public static Object[] aranacakKelimeListesi() {

        String arr[]={"Nutella","Java","Apple"};
        return arr;
    }

    @Test (dataProvider = "aranacakKelimeListesi")
    public void test(String aranacak){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPagePOM amazonPage = new AmazonPagePOM(Driver.getDriver());
        amazonPage.aramaKutusu.sendKeys(aranacak+ Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains(aranacak));
    }
}
