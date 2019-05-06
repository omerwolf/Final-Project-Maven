package Model.WriteOutput;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlsxFileGenerator {

    public String getFilePath() {
        Workbook workbook = new XSSFWorkbook(); //create  a XLSX file.
        Sheet sheet = workbook.createSheet("first sheet");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);




        return null;
    }
}
