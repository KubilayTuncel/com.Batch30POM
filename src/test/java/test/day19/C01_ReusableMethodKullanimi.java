package test.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class C01_ReusableMethodKullanimi {

    //https://the-internet.herokuapp.com/windows
    //click her butonuna tikla
    //yeni cikan sayfada new window yazisinin göründügünü test edelim

    @Test
    public void test1() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();
        Set<String> windowHandleKümesi=Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandleDegeri="";

        for (String each:windowHandleKümesi
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri=each;
                }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());

        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowYaziElementi.isDisplayed(),"yazi elenti görüntülenemedi");
        Driver.closeDriver();
    }

    @Test
    public void ReusableTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed(),"yazi elenti görüntülenemedi");
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
