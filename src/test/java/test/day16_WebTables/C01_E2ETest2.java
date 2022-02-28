package test.day16_WebTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest2 {

    @Test
    public void RoomCreateTest() throws InterruptedException {
        //3. https://qa-environment.concorthotel.com/ adresine gidin.
        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        // a. Username : manager  b. Password  : Manager1!
        // 5. Login butonuna tıklayın.
        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        // 8. Save butonuna basin.
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        //10. OK butonuna tıklayın.
        //11. Hotel rooms linkine tıklayın.
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.LoginMethod();
        qaConcortPage.hotelManage.click();
        qaConcortPage.hotelRoom.click();
        qaConcortPage.addHotelRoom.click();
        Select select = new Select(qaConcortPage.addRoomIdDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIdHotel"));

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        actions.sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(faker.lorem().paragraph()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQARoomPrice")).perform();

        select = new Select(qaConcortPage.roomTypeDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQARoomType"));

        actions.sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1,10))).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,10))).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        qaConcortPage.saveButton.click();

            Thread.sleep(5000);
        Assert.assertTrue(qaConcortPage.kaydedildiYazisi.isDisplayed());
        Thread.sleep(5000);
        qaConcortPage.clickButonu.click();
        actions.sendKeys(Keys.HOME).perform();
        qaConcortPage.addRoomHome.click();
        Assert.assertTrue(qaConcortPage.addRoomListYazisi.isDisplayed());
        Driver.closeDriver();

    }
}
