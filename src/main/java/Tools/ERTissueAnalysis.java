package Tools;

import DB.Entites.TissueAnalysis;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ERTissueAnalysis {
    static String fileName = "src/main/resources/parameter_per_stage.xlsx";
    public ERTissueAnalysis() {

    }

    public List<TissueAnalysis> readExcelData() {
        List<TissueAnalysis> parameterPerStageList = new ArrayList<TissueAnalysis>();

        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (fileName.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();

            //loop through each of the sheets
            for (int i = 0; i < numberOfSheets; i++) {

                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);

                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {

                    Double nutrientPerStageId = null;
                    Double paramPerCropId = null;
                    Double varietyId = null;
                    Double phenologicalStageId = null;
                    Double percent = null;

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        //Get the Cell object
                        Cell cell = cellIterator.next();

                        //check the cell type and process accordingly
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                if (nutrientPerStageId == null) {
                                    nutrientPerStageId = cell.getNumericCellValue();
                                } else if (paramPerCropId == null) {
                                    //2nd column
                                    paramPerCropId = cell.getNumericCellValue();
                                } else if (varietyId == null) {
                                    varietyId = cell.getNumericCellValue();
                                } else if (phenologicalStageId == null) {
                                    phenologicalStageId = cell.getNumericCellValue();
                                } else if (percent == null) {
                                    percent = cell.getNumericCellValue();
                                } else {
                                    System.out.println("Random data::" + cell.getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                //random data, leave it
                                System.out.println("Random data::" + cell.getStringCellValue());

                        }//end of cell iterator

                    } //end of rows iterator
                    if (nutrientPerStageId != null && paramPerCropId != null && varietyId != null
                            && phenologicalStageId != null && percent != null) {
                        TissueAnalysis pps = new TissueAnalysis();
                        parameterPerStageList.add(pps);
                    } else{
                        System.out.println("row number " + row.getRowNum() + " have null!!");
                    }
                } //end of sheets for loop
                //close file input stream
                fis.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return parameterPerStageList;
    }
}
