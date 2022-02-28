package test.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {
    @Test
    public void test1(){
        // amazon sayfasina gidip
        // nutella icin arama yapalim
        // sonuc sayisinin 1000'den az oldugunu test edelim
        extentTest =extentReports.createTest("Nutella testi","sonuc sayisi 1000 az olmali");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");

        WebElement sonucYazisiElementi= Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiElementi.getText());
        String sonucYazisi = sonucYazisiElementi.getText();
        String arr1[]=sonucYazisi.split(" ");
        int sonucSayisi=Integer.parseInt(arr1[2]);
        extentTest.info("sonuc yazisi interger haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000 den az oldugu test edildi");
    }

    @Test
    public void test2(){
        // amazon sayfasina gidip
        // samsung icin arama yapalim
        // sonuc sayisinin 1000'den az oldugunu test edelim
        extentTest =extentReports.createTest("Samsung testi","sonuc sayisi 1000 az olmali");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung"+ Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");

        WebElement sonucYazisiElementi= Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiElementi.getText());
        String sonucYazisi = sonucYazisiElementi.getText();
        String arr1[]=sonucYazisi.split(" ");
        String sonucSayisi=arr1[3];
        sonucSayisi=sonucSayisi.replace(",","");
        int sonucAdedi=Integer.parseInt(sonucSayisi);
        extentTest.info("sonuc yazisi interger haline getirildi");

        Assert.assertTrue(sonucAdedi<1000);
        extentTest.pass("sonuc sayisinin 1000 den az oldugu test edildi");
    }

    @Test
    public void test3(){
        // amazon sayfasina gidip
        // electronic kategorisinde java icin arama yapalim
        // cikan sonuclardan ilkinin isminde java oldugunu test edelim
        extentTest =extentReports.createTest("Java testi","ilk urunde Java yazisi olmali");
        Driver.getDriver().get("https://www.amazon.com");
        extentTest.info("Amazon sayfasina gidildi.");

        WebElement dropDown = Driver.getDriver().findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Electronics");
        extentTest.info("DropDown dan Electronics secildi");
        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        extentTest.info("Java kelimesi aratildi");
        WebElement javaYazisi= Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-normal'])[2]"));
        String actualSonucYazisi = javaYazisi.getText();

        Assert.assertTrue(actualSonucYazisi.contains("Java"), "ilk sonucta java yazisi bulunmuyor");
        extentTest.pass("ilk urun isminde Java yazisi  oldugu test edildi");

    }
}
