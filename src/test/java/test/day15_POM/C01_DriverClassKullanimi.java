package test.day15_POM;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

        //Driver class indan obje uretilemesin istedigimiz icin Driver class i SINGLETON yapiyoruz
        //bunun icin default constructor yerine parametresiz bir const. olusturup access modifer i private seciyoruz

        Driver.closeDriver();
    }
}
