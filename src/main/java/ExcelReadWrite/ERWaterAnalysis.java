package ExcelReadWrite;



import DB.Dao.LabAnalysisResultDao;
import DB.DaoImpl.LabAnalysisResultDaoImpl;
import DB.Entites.LabAnalysisResult;
import DB.Entites.ParameterPerStage;
import DB.WaterAnalysis.WaterAnalysis;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Now;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ERWaterAnalysis {
    private String path;

    public ERWaterAnalysis(String path) {
        this.path = path;
    }

    public WaterAnalysis read() {
        WaterAnalysis waterAnalysis = new WaterAnalysis();
        List<LabAnalysisResult> labAnalysisResultList = new ArrayList<>();
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
                //get date
                LocalDate sample_date = null;
                if (DateUtil.isCellDateFormatted(firstSheet.getRow(4).getCell(1))){
                Date date = DateUtil.getJavaDate(firstSheet.getRow(4).getCell(1).getNumericCellValue());
                sample_date = date.toInstant().atZone((ZoneId.systemDefault())).toLocalDate();
                //System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));
                }
                String sample_name = firstSheet.getRow(5).getCell(1).getStringCellValue();
                int ib_id = (int) firstSheet.getRow(7).getCell(1).getNumericCellValue();
                double water_EC = firstSheet.getRow(8).getCell(1).getNumericCellValue();
                double water_pH = firstSheet.getRow(9).getCell(1).getNumericCellValue();

                try{
                    waterAnalysis = new WaterAnalysis(water_analysis_id,is_active,farm_id,sample_date,sample_name,ib_id,water_EC,water_pH);
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("failed to create water analysis");
                }

                try {
                    /*
                     * READ PARAMETERS
                     */
                    double p1Val = firstSheet.getRow(10).getCell(1).getNumericCellValue();
                    double p13Val = firstSheet.getRow(11).getCell(1).getNumericCellValue();
                    double p14Val = firstSheet.getRow(12).getCell(1).getNumericCellValue();
                    double p2Val = firstSheet.getRow(13).getCell(1).getNumericCellValue();
                    double p3Val = firstSheet.getRow(14).getCell(1).getNumericCellValue();
                    double p4Val = firstSheet.getRow(15).getCell(1).getNumericCellValue();
                    double p5Val = firstSheet.getRow(16).getCell(1).getNumericCellValue();
                    double p6Val = firstSheet.getRow(17).getCell(1).getNumericCellValue();
                    double p7Val = firstSheet.getRow(18).getCell(1).getNumericCellValue();
                    double p8Val = firstSheet.getRow(19).getCell(1).getNumericCellValue();
                    double p9Val = firstSheet.getRow(20).getCell(1).getNumericCellValue();
                    double p10Val = firstSheet.getRow(21).getCell(1).getNumericCellValue();
                    double p11Val = firstSheet.getRow(22).getCell(1).getNumericCellValue();
                    double p12Val = firstSheet.getRow(23).getCell(1).getNumericCellValue();
                    double p16Val = firstSheet.getRow(24).getCell(1).getNumericCellValue();
                    double p17Val = firstSheet.getRow(25).getCell(1).getNumericCellValue();
                    double p18Val = firstSheet.getRow(26).getCell(1).getNumericCellValue();
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,1,p1Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,2,p2Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,3,p3Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,4,p4Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,5,p5Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,6,p6Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,7,p7Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,8,p8Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,9,p9Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,10,p10Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,11,p11Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,12,p12Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,13,p13Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,14,p14Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,16,p16Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,17,p17Val));
                    labAnalysisResultList.add(new LabAnalysisResult(null,null,water_analysis_id,18,p18Val));
                    LabAnalysisResultDao larDao = new LabAnalysisResultDaoImpl();
                    larDao.insertAll(labAnalysisResultList);
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("wrong read parameters - lab analysis");
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
