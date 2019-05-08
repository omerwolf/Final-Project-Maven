package Model.WriteOutput;


import Model.UserInput;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class XlsxFileGenerator {
    private UserInput ui;
    private String filePath;

    public XlsxFileGenerator(UserInput ui) {
        this.ui = ui;
    }

    public Workbook getWorkbook(){
        Workbook workbook = new XSSFWorkbook(); //create  a XLSX file.
        Sheet sheet = workbook.createSheet("general info");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Run name:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getRunName());

        row = sheet.createRow(1);
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH-mm").format(Calendar.getInstance().getTime());
        cell = row.createCell(0);
        cell.setCellValue("TimeStamp:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(timeStamp);

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("Crop:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedCrop().getName());

        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("Variety:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedVarType().getVariety_name());

        row = sheet.createRow(4);
        cell = row.createCell(0);
        cell.setCellValue("Soil:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedSoil().getName());

        row = sheet.createRow(5);
        cell = row.createCell(0);
        cell.setCellValue("Expected yield:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedexpectedYield());


        row = sheet.createRow(6);
        cell = row.createCell(0);
        cell.setCellValue("N credit:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedNCredit());

        row = sheet.createRow(7);
        cell = row.createCell(0);
        cell.setCellValue("Irrigation method:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedIrrigationMethod().getIrrigation_method_desc());

        row = sheet.createRow(8);
        cell = row.createCell(0);
        cell.setCellValue("Irrigation volume:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedIrrigationVolume());

        row = sheet.createRow(9);
        cell = row.createCell(0);
        cell.setCellValue("Fertilization method:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedFertilizationMethod().getFert_method_desc());


        row = sheet.createRow(10);
        cell = row.createCell(0);
        cell.setCellValue("Base dressing:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedBaseDressing());

        row = sheet.createRow(11);
        cell = row.createCell(0);
        cell.setCellValue("Soil correction:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedSoilCorrection());

        row = sheet.createRow(12);
        cell = row.createCell(0);
        cell.setCellValue("Soil pH:");
        cell.setCellStyle(headerCellStyle);
        row.createCell(1).setCellValue(ui.getSelectedSoilPH());

        row = sheet.createRow(13);
        cell = row.createCell(0);
        cell.setCellValue("Date:");
        cell.setCellStyle(headerCellStyle);
        LocalDate date = ui.getSelectedDate();
        row.createCell(1).setCellValue(date.getDayOfMonth() + "/" + date.getMonthValue() +
                "/" + date.getYear());


        // Resize all columns to fit the content size
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }


        this.filePath = "Output/" + timeStamp + ".xlsx";
        try {
            OutputStream fileOut = new FileOutputStream(new File(filePath));
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            System.err.println("Could not create XLSX file at " + filePath);
            e.printStackTrace();
        }


        return workbook;
    }

    public String getFilePath() {
        return filePath;
    }
}
