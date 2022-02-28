package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {
    // abstract yaparak bu class'dan obje olusturulmasinin onune geceriz
    // biz test base class'i sadece extends ile inherit ederek kullanacagiz
    // dolayisiyla olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

        driver = DriverCross.getDriver(browser);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {DriverCross.closeDriver();;
    }
}
