package test.day15_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {

    @Test
    public void createHotel() throws InterruptedException {
        //1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //    a. Username : manager
        //    b. Password  : Manager1!
        //5. Login butonuna tıklayın.
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8. Save butonuna tıklayın.
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        //10. OK butonuna tıklayın.

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.logIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidusername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.enterButonu.click();
        qaConcortPage.hotelManage.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addHotel.click();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(qaConcortPage.code).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .perform();

        qaConcortPage.dropDown.click();
        Select select = new Select(qaConcortPage.dropDown);
        select.selectByIndex(1);
        qaConcortPage.saveButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(qaConcortPage.kaydedildiYazisi.isDisplayed());
        Driver.closeDriver();

    }
}
