package crossBrowser;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class PositiveLoginTest extends TestBaseCross {
    //cross browser testte TEstbase class ina geri donuyoruz. Bunun sebebi  @parameters notasyonunu kullanmak

    //Bir test method olustur positiveLoginTest()
    // https://qa-environment.concorthotel.com/ adresine git
    // login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest() throws InterruptedException {
        driver.get(ConfigReader.getProperty("CHQAUrl"));
        driver.findElement(By.xpath( "//a[text()='Log in']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@class='form-control required']")).sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        driver.findElement(By.xpath("//input[@class='form-control required password']")).sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='ListOfUsers']")).isDisplayed());

    }

}
