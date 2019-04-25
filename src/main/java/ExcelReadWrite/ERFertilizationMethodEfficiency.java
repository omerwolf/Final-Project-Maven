package ExcelReadWrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DB.Entites.FertilizationMethodEfficiency;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ERFertilizationMethodEfficiency{
    static String fileName = "src/main/resources/fertilization_method_efficiency.xlsx";



    public List<FertilizationMethodEfficiency> readExcelData() {
        List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList = new ArrayList<FertilizationMethodEfficiency>();

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

                        Integer fert_method_efficiency_id = null;
                        Integer fert_method_id = null;
                        Integer parameter_id = null;
                        Double fert_method_efficiency = null;

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
                                    if (fert_method_efficiency_id == null) {
                                        fert_method_efficiency_id = (int)cell.getNumericCellValue();
                                    } else if (fert_method_id == null) {
                                        //2nd column
                                        fert_method_id = (int)cell.getNumericCellValue();
                                    } else if (parameter_id == null) {
                                        parameter_id = (int)cell.getNumericCellValue();
                                    } else if (fert_method_efficiency == null) {
                                        fert_method_efficiency = cell.getNumericCellValue();
                                    } else {
                                        System.out.println("Random data::" + cell.getNumericCellValue());
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    //random data, leave it
                                    System.out.println("Random data::" + cell.getStringCellValue());
                                    break;
                            }//end of cell iterator

                        } //end of rows iterator
                        if (fert_method_efficiency_id != null && fert_method_id != null && parameter_id != null
                                && fert_method_efficiency != null) {
                            FertilizationMethodEfficiency fme = new FertilizationMethodEfficiency(fert_method_efficiency_id,
                                    fert_method_id,parameter_id,fert_method_efficiency);
                            fertilizationMethodEfficiencyList.add(fme);
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

            return fertilizationMethodEfficiencyList;
        }
    }


