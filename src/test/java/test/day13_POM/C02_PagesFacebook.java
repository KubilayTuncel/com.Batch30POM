package test.day13_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    // facebook login sayfasina gidin
// kullanici adi : techproed
// sifre : 12345
// yazdigimizda giris yapamadigimizi test edin
    //page sayfasinda cookiesGec() method'u olusturun

    @Test
    public void facebook(){
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage = new FacebookPage(driver);
        facebookPage.cookies.click();
        facebookPage.userName.sendKeys("techproed@gmail.com"+ Keys.TAB);
        facebookPage.password.sendKeys("12345"+Keys.TAB+Keys.TAB+Keys.ENTER);

        Assert.assertTrue(facebookPage.alertYazisiElementi.isDisplayed(),"Alert yazisi bulunamadi");
    }


}
