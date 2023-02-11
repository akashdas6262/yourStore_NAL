package baseUtility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class xlsxReader {
    //    String path;
//    FileInputStream fis = null;
//    FileInputStream fileOut = null;
//    private XSSFWorkbook workbook = null;
//    private XSSFSheet sheet = null;
//    private XSSFRow row = null;
//    private XSSFCell cell = null;
//
//
//    public void ReadExcelSheet(String path) {
//        this.path = path;
//        try {
//            fis = new FileInputStream(path);
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheetAt(0);
//            fis.close();
//        } catch (Exception e) {
//        }
//    }
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public void readExcelData(String Excelpath) throws IOException {
        try {

            File src = new File(Excelpath);
            FileInputStream fis = new FileInputStream(src);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public String getData(int sheetNumber, int row, int column) {
        String excelData = sheet.getRow(row).getCell(column).getStringCellValue();
        return excelData;
    }


}
