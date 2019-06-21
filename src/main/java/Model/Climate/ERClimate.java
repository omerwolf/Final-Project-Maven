package Model.Climate;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
 * reads the excel file of the climate info,
 * in order to insert it's values to the database.
 */
public class ERClimate {
    List<MonthClimate> monthClimateList;
    static String fileName = "src\\main\\resources\\Climate.xlsx";

    /**
     * reads the climate data from the excel,
     * creates records, and add them to the monthClimateList member.
     */
    public ERClimate() {
        this.monthClimateList = new ArrayList<>();
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
                if (!row.getCell(0).getStringCellValue().equals("0")) {
                    int monthNum = row.getRowNum();
                    int rain = (int)row.getCell(1).getNumericCellValue();
                    int temp = (int)row.getCell(2).getNumericCellValue();
                    MonthClimate mc = new MonthClimate(monthNum,rain,temp);
                    monthClimateList.add(mc);
                }
            }
            //close file input stream
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * returns the climate list if it exists.
     * @return the monthClimateList
     */
    public List<MonthClimate> getMonthClimateList() {
        if (this.monthClimateList == null) {
            System.out.println("monthClimateList is not initialized");
        }
        return this.monthClimateList;
    }

    /**
     * receives a number of a month (1-12) and returns it from the monthClimateList.
     * @param monthNum - the month number.
     * @return the MonthClimate of that month (with info about rain and temperature).
     */
    public MonthClimate getMonth(int monthNum){
        return this.monthClimateList.get(monthNum - 1);
    }
}
