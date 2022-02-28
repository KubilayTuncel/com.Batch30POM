package test.day16_WebTables;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_WebTable {
    //● login() metodun oluşturun ve oturum açın.
    //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
    // ○ Username : manager
    // ○ Password : Manager1!
    //● table() metodu oluşturun
    // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows() metodu oluşturun //tr
    // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.


    @Test
    public void test() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.LoginMethod();
        qaConcortPage.hotelManage.click();
        qaConcortPage.hotelRoom.click();
        System.out.println("tablodaki basliklarin sayisi "+qaConcortPage.basliklarListesi.size());
        qaConcortPage.basliklarListesi.stream().forEach(t-> System.out.println(t.getText()));
        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("HAPPY HOTEL"));

        System.out.println("tablodaki satir sayisi "+qaConcortPage.satirlarListesi.size());

        System.out.println(qaConcortPage.ilkSatir.getText());

        //eger tum satirlari yazdirmak istersek
        for (int i=0; i<qaConcortPage.satirlarListesi.size(); i++){
            System.out.println(i+1 +". satir : "+qaConcortPage.satirlarListesi.get(i).getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        qaConcortPage.dorduncuSutunListesi.stream().forEach(t-> System.out.println(t.getText()));
        Driver.closeDriver();

    }

}
