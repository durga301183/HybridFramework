package Sync_utils;

import BaseTest.BaseTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends BaseTest {

   public static long PAGE_LOAD_TIMEOUT = 20;
   public static long IMPLICIT_WAIT = 10;
   static Workbook book;
   static Sheet sheet;
   public static final String TESTDATA_SHEET_PATH = "C:/Users/G S Sastry/Axone Workspace/Framework/src/test/resources/Book1.xlsx";
   public static final String sheetName = "CONTACTS";

   public void switchToFrame() {
      driver.switchTo().frame("mainpanel");
   }

   public static Object[][] getTestData(String sheetName) {
      FileInputStream file = null;
      try {
         file = new FileInputStream(TESTDATA_SHEET_PATH);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      try {
         book = WorkbookFactory.create(file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      sheet = book.getSheet(sheetName);
      Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
      for (int i = 0; i < sheet.getLastRowNum(); i++) {

         for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
            data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
         }

      }
      return data;
   }


}