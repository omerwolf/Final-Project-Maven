package ExcelReadWrite;



import DB.WaterAnalysis.WaterAnalysis;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Now;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ERWaterAnalysis {
    private String path;

    public ERWaterAnalysis(String path) {
        this.path = path;
    }

    public WaterAnalysis read() {
        WaterAnalysis waterAnalysis = new WaterAnalysis();
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(path);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (path.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (path.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            //Get the 1th sheet from the workbook
            Sheet firstSheet = workbook.getSheetAt(0);

            if (firstSheet.getRow(0).getCell(1).getStringCellValue().equals("Value") &&
                    firstSheet.getRow(6).getCell(1).getStringCellValue().equals("Irrigation")){
                int water_analysis_id = (int) firstSheet.getRow(1).getCell(1).getNumericCellValue();
                boolean is_active = this.getIsActive(firstSheet.getRow(2).getCell(1).getStringCellValue());
                int farm_id = (int) firstSheet.getRow(3).getCell(1).getNumericCellValue();
                if (DateUtil.isCellDateFormatted(firstSheet.getRow(4).getCell(1))){
                    System.out.print(firstSheet.getRow(4).getCell(1).getDateCellValue());

                }
                LocalDate sample_date = LocalDate.parse("2016-08-16");
                String sample_name = firstSheet.getRow(5).getCell(1).getStringCellValue();
                int ib_id = (int) firstSheet.getRow(7).getCell(1).getNumericCellValue();
                double water_EC = firstSheet.getRow(8).getCell(1).getNumericCellValue();
                double water_pH = firstSheet.getRow(9).getCell(1).getNumericCellValue();
                try{
                    waterAnalysis = new WaterAnalysis(water_analysis_id,is_active,farm_id,sample_date,
                            sample_name,ib_id,water_EC,water_pH);
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("failed to create water analysis");
                }
                } else {
                System.out.println("wrong 2 row selected");
            }
            //close file input stream
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return waterAnalysis;
    }

    private LocalDate getSampleDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        System.out.println(formatter.format(localDate));
        return localDate;
    }

    private Boolean getIsActive(String s){
        if(s.toLowerCase().equals("yes") || s.toLowerCase().equals("true")) {
            return true;
        }else if(s.toLowerCase().equals("no") || s.toLowerCase().equals("false")) {
            return false;
        }else {
            System.out.println("wrong in_active filed - water analysis");
        }
        return false;
    }
}
