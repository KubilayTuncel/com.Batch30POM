package test.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class c01_ReadExcel {

    @Test (groups = "birinciGrup")
    public void test1() throws IOException{
        //7.Dosya yolunu bir String degiskene atayalim
        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(2);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        //7.Dosya yolunu bir String degiskene atayalim
        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=workbook.getSheet("Sayfa1").getRow(5).getCell(3);
        System.out.println(cell);
        //secilen hucredeki yazinin Luanda oldugunu test edin
        //cell'in data turu Cell, "Luanda" ise String
        //data turleri farkli oldugu icin bu ikisi equals edilemez
        //cell data tutru yazdirilabilir ancak string methodlari ile kullanilamaz
        //String manipulation yapmak icin Cell data turunu String'e Cast yapmaliyiz
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //index'i 3 olan satirdaki index'i 2 olan hucredeki yaziyi buyuk harfle yazdirin.
        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        String hucre=cell1.toString();
        System.out.println(hucre.toUpperCase(Locale.ROOT));

        //getLastRowNum() bize son satirin index'ini verir
        //getPhysicalNumberOfRows() ise fiili olarak kullanilan satir sayisini verir
        //getFirstRowNum() kullanilan ilk satir numarasinin index'ini verir.
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum());
    }

    @Test
    public void test3() throws IOException {
        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        List<String> ikinciSutun=new ArrayList<>();

        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++){
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);
        List<String> aIleBaslayanSehirler = new ArrayList<>();

        for (String each:ikinciSutun){
            if (each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }
        }
        System.out.println(aIleBaslayanSehirler);

        Map<String,String> ulkelerMap =new HashMap<>();
        String key="";
        String value="";
        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++){
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
        //Biz Java methodlarini ve Collection i kullanarak excel deki datalari manipule edebilecegimiz
        //Java ortamina alabiliriz.
    }




}
