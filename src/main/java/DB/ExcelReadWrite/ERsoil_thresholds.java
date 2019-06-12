package DB.ExcelReadWrite;

import DB.Entites.soil_thresholds;
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

/**
 * reads the excel file of the soil info,
 * in order to insert it's values to the database.
 */
public class ERsoil_thresholds {
    static String fileName = "src\\main\\resources\\soil_thresholds.xlsx";

    /**
     * the default constructor.
     */
    public ERsoil_thresholds() {
    }

    /**
     * reads from the file name (set as static String) the required information for each row
     * in the excel file. the values from each row are used in order to create the
     * Soil records, that will be added to a list that will than
     * be returned.
     * @return a list of the records that were added from the excel file.
     */
    public List<soil_thresholds> readExcelData() {
        List<soil_thresholds> soilThresholdsList = new ArrayList<soil_thresholds>();

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

            Sheet sheet = workbook.getSheetAt(0);

            //every sheet has rows, iterate over them
            Iterator<Row> rowIterator = sheet.iterator();
            //skip header row
            rowIterator.next();
            while (rowIterator.hasNext()) {
                //Get the row object
                Row row = rowIterator.next();
                if (row.getCell(0).getNumericCellValue() != 0) {
                    int soil_threshold_id = (int) row.getCell(0).getNumericCellValue();
                    int lab_id = (int) row.getCell(1).getNumericCellValue();
                    int extraction_method_id = (int) row.getCell(2).getNumericCellValue();
                    int parameter_id = (int) row.getCell(4).getNumericCellValue();
                    int uom_id = (int) row.getCell(5).getNumericCellValue();
                    double very_low_threshold = row.getCell(11).getNumericCellValue();
                    double low_threshold = row.getCell(12).getNumericCellValue();
                    double target_value = row.getCell(13).getNumericCellValue();
                    double high_threshold = row.getCell(14).getNumericCellValue();
                    double very_high_threshold = row.getCell(15).getNumericCellValue();
                    soil_thresholds st = new soil_thresholds(soil_threshold_id, lab_id, extraction_method_id,
                            parameter_id, uom_id, very_low_threshold, low_threshold, target_value, high_threshold,
                            very_high_threshold);
                    soilThresholdsList.add(st);
                }
            }
            //close file input stream
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return soilThresholdsList;
    }
}
