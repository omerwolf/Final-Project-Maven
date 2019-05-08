package Model.WriteOutput;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import Model.UserInput;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteOutput {
    final int NUM_OF_COLUMNS = 13; //The amount of members at WriteOutput class
    final String filePate;
    final Workbook workbook;

    public WriteOutput(UserInput ui){
        XlsxFileGenerator fileGenerator = new XlsxFileGenerator(ui);
        this.workbook = fileGenerator.getWorkbook();
        this.filePate = fileGenerator.getFilePath();
    }
    public void writeNutrientsOutput(List<NutrientsOutput> nutrientsOutput) throws Exception{
        int numOfSheets = this.workbook.getNumberOfSheets();
        Sheet sheet = this.workbook.createSheet("Nutrients");
        Row row = sheet.createRow(0);
        this.writeNutrientsOutputHeader(row);

        for (int i = 1; i <= nutrientsOutput.size(); i++) {
            row = sheet.createRow(i);
            this.writeNutrientsOutputData(row, nutrientsOutput.get(i-1));
            }


        // Resize all columns to fit the content size
        for (int i = 0; i < NUM_OF_COLUMNS; i++) {
            sheet.autoSizeColumn(i);
        }


        FileOutputStream fos = new FileOutputStream(this.filePate);
        workbook.write(fos);
        fos.close();
        System.out.println("NutrientsOutput:: " + this.filePate + " written successfully");


    }

    public void writeWaterAnalysisOutput(List<WaterAnalysisOutput> waterAnalysisOutput) throws Exception{
        int numOfSheets = this.workbook.getNumberOfSheets();
        Sheet sheet = this.workbook.createSheet("Water analysis interpretation");
        Row row = sheet.createRow(0);
        this.writeWaterAnalysisOutputHeader(row);

        for (int i = 1; i <= waterAnalysisOutput.size(); i++) {
            row = sheet.createRow(i);
            this.writeWaterAnalysisOutputData(row, waterAnalysisOutput.get(i-1));
        }


        // Resize all columns to fit the content size
        for (int i = 0; i < NUM_OF_COLUMNS; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fos = new FileOutputStream(this.filePate);
        workbook.write(fos);
        fos.close();
        System.out.println("WaterAnalysisOutput:: " + this.filePate + " written successfully");


    }

    public void writeSoilAnalysisOutput(List<SoilAnalysisOutput> soilAnalysisOutput) throws Exception{
        int numOfSheets = this.workbook.getNumberOfSheets();
        Sheet sheet = this.workbook.createSheet("Soil analysis interpretation");
        Row row = sheet.createRow(0);
        this.writeSoilAnalysisOutputHeader(row);

        for (int i = 1; i <= soilAnalysisOutput.size(); i++) {
            row = sheet.createRow(i);
            this.writeSoilAnalysisOutputData(row, soilAnalysisOutput.get(i-1));
        }


        // Resize all columns to fit the content size
        for (int i = 0; i < NUM_OF_COLUMNS; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fos = new FileOutputStream(this.filePate);
        workbook.write(fos);
        fos.close();
        System.out.println("SoilAnalysisOutput:: " + this.filePate + " written successfully");


    }

    private void writeNutrientsOutputHeader(Row firstRow) {
        // Change font and color
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Cell cell = firstRow.createCell(1);
        cell.setCellValue("N");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(2);
        cell.setCellValue("P205");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(3);
        cell.setCellValue("K20");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(4);
        cell.setCellValue("Ca0");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(5);
        cell.setCellValue("Mg0");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(6);
        cell.setCellValue("S");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(7);
        cell.setCellValue("Fe");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(8);
        cell.setCellValue("B");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(9);
        cell.setCellValue("Mn");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(10);
        cell.setCellValue("Zn");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(11);
        cell.setCellValue("Cu");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(12);
        cell.setCellValue("Mo");
        cell.setCellStyle(headerCellStyle);
    }

    private void writeNutrientsOutputData(Row row, NutrientsOutput no ) {

        Cell cell = row.createCell(0);
        cell.setCellValue(no.getStageName());

        cell = row.createCell(1);
        cell.setCellValue(no.getN());

        cell = row.createCell(2);
        cell.setCellValue(no.getP205());

        cell = row.createCell(3);
        cell.setCellValue(no.getK20());

        cell = row.createCell(4);
        cell.setCellValue(no.getCa0());

        cell = row.createCell(5);
        cell.setCellValue(no.getMg0());

        cell = row.createCell(6);
        cell.setCellValue(no.getS());

        cell = row.createCell(7);
        cell.setCellValue(no.getFe());

        cell = row.createCell(8);
        cell.setCellValue(no.getB());

        cell = row.createCell(9);
        cell.setCellValue(no.getMn());

        cell = row.createCell(10);
        cell.setCellValue(no.getZn());

        cell = row.createCell(11);
        cell.setCellValue(no.getCu());

        cell = row.createCell(12);
        cell.setCellValue(no.getMo());

    }
    private void writeWaterAnalysisOutputHeader(Row firstRow) {
        // Change font and color
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Cell cell = firstRow.createCell(1);
        cell.setCellValue("Water nutrients");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(2);
        cell.setCellValue("results units");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(3);
        cell.setCellValue("Applied nutrients");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(4);
        cell.setCellValue("Efficiency");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(5);
        cell.setCellValue("Actual nutrients kg");
        cell.setCellStyle(headerCellStyle);

    }
    private void writeWaterAnalysisOutputData(Row row, WaterAnalysisOutput wao ) {

        Cell cell = row.createCell(0);
        cell.setCellValue(wao.getNutrientSymbol());

        cell = row.createCell(1);
        cell.setCellValue(wao.getWaterNutrients());

        cell = row.createCell(2);
        cell.setCellValue(wao.getResultsUnits());

        cell = row.createCell(3);
        cell.setCellValue(wao.getAppliedNutrients());

        cell = row.createCell(4);
        cell.setCellValue(wao.getEfficiency());

        cell = row.createCell(5);
        cell.setCellValue(wao.getActualNutrientsKg());
    }
    private void writeSoilAnalysisOutputHeader(Row firstRow) {
        // Change font and color
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Cell cell = firstRow.createCell(1);
        cell.setCellValue("Nutrients result");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(2);
        cell.setCellValue("Analysis status");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(3);
        cell.setCellValue("Threshold");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(4);
        cell.setCellValue("Nutrient balance");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(5);
        cell.setCellValue("Recommendation");
        cell.setCellStyle(headerCellStyle);

        cell = firstRow.createCell(5);
        cell.setCellValue("Correction");
        cell.setCellStyle(headerCellStyle);

    }
    private void writeSoilAnalysisOutputData(Row row, SoilAnalysisOutput sao ) {

        Cell cell = row.createCell(0);
        cell.setCellValue(sao.getNutrientSymbol());

        cell = row.createCell(1);
        cell.setCellValue(sao.getNutrientBalance());

        cell = row.createCell(2);
        cell.setCellValue(sao.getAnalysisStatus());

        cell = row.createCell(3);
        cell.setCellValue(sao.getThresholds());

        cell = row.createCell(4);
        cell.setCellValue(sao.getNutrientBalance());

        cell = row.createCell(5);
        cell.setCellValue(sao.getRecommendation());

        cell = row.createCell(6);
        cell.setCellValue(sao.getCorrection());
    }

}
