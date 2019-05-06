package Analysis.SoilAnalysis;

import Analysis.LabAnalysisResults.LabAnalysisResultDao;
import Analysis.LabAnalysisResults.LabAnalysisResultDaoImpl;
import Analysis.LabAnalysisResults.SoilLabAnalysisResult;
import DB.Dao.ExtractionMethodDao;
import DB.Dao.SoilDao;
import DB.Dao.layer_depth_typeDao;
import DB.DaoImpl.ExtractionMethodDaoImpl;
import DB.DaoImpl.SoilDaoImpl;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.Entites.ExtractionMethod;
import DB.Entites.Soil;
import DB.Entites.layer_depth_type;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ERSoilAnalysis {
     String path;
     List<ExtractionMethod> emList;


    public ERSoilAnalysis(String path) {
        this.path = path;
    }

    public int read() {
        Integer soilAnalysisId = null;
        SoilAnalysis soilAnalysis = null;
        List<SoilLabAnalysisResult> labAnalysisResultList = new ArrayList<>();
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
                    firstSheet.getRow(1).getCell(1).getStringCellValue().equals("Soil")){

                String sample_name = firstSheet.getRow(2).getCell(1).getStringCellValue();
                int soil_analysis_id = (int)firstSheet.getRow(3).getCell(1).getNumericCellValue();
                boolean is_active = this.getIsActive(firstSheet.getRow(4).getCell(1).getStringCellValue());
                int farm_id = (int)firstSheet.getRow(5).getCell(1).getNumericCellValue();
                LocalDate sample_date = this.getLocalDate(firstSheet.getRow(6).getCell(1));
                int lab_id = (int)firstSheet.getRow(7).getCell(1).getNumericCellValue();
                int soil_type_id = this.getSoilTypeId(firstSheet.getRow(8).getCell(1).getStringCellValue());
                int layer_depth_id = this.getLayerDepthId(firstSheet.getRow(9).getCell(1).getStringCellValue());
                int irrigation_block_id = (int)firstSheet.getRow(10).getCell(1).getNumericCellValue();
                double organic_matter = firstSheet.getRow(11).getCell(1).getNumericCellValue();
                double bulk_density = firstSheet.getRow(12).getCell(1).getNumericCellValue();
                double soil_pH = firstSheet.getRow(14).getCell(1).getNumericCellValue();
                double soil_EC = firstSheet.getRow(15).getCell(1).getNumericCellValue();
                double soil_CEC = firstSheet.getRow(16).getCell(1).getNumericCellValue();


                try{
                    soilAnalysis = new SoilAnalysis(sample_name,soil_analysis_id,is_active,farm_id,sample_date,lab_id,
                            soil_type_id,layer_depth_id,irrigation_block_id,organic_matter,bulk_density,soil_pH,
                            soil_EC,soil_CEC);
                    //insert to soil_lab_analysis schema
                    SoilAnalysisDao sad = new SoilAnalysisDaoImpl();
                    sad.insert(soilAnalysis);
                    soilAnalysisId = soil_analysis_id;
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("failed to create water analysis");
                }

                try {
                    /*
                     * READ PARAMETERS
                     */
                    double p1Val = firstSheet.getRow(17).getCell(1).getNumericCellValue();
                    double p13Val = firstSheet.getRow(18).getCell(1).getNumericCellValue();
                    double p14Val = firstSheet.getRow(19).getCell(1).getNumericCellValue();
                    double p15Val = firstSheet.getRow(20).getCell(1).getNumericCellValue();
                    double p2Val = firstSheet.getRow(21).getCell(1).getNumericCellValue();
                    double p3Val = firstSheet.getRow(22).getCell(1).getNumericCellValue();
                    double p4Val = firstSheet.getRow(23).getCell(1).getNumericCellValue();
                    double p5Val = firstSheet.getRow(24).getCell(1).getNumericCellValue();
                    double p6Val = firstSheet.getRow(25).getCell(1).getNumericCellValue();
                    double p7Val = firstSheet.getRow(26).getCell(1).getNumericCellValue();
                    double p8Val = firstSheet.getRow(27).getCell(1).getNumericCellValue();
                    double p9Val = firstSheet.getRow(28).getCell(1).getNumericCellValue();
                    double p10Val = firstSheet.getRow(29).getCell(1).getNumericCellValue();
                    double p11Val = firstSheet.getRow(30).getCell(1).getNumericCellValue();
                    double p12Val = firstSheet.getRow(31).getCell(1).getNumericCellValue();
                    double p16Val = firstSheet.getRow(32).getCell(1).getNumericCellValue();
                    double p17Val = firstSheet.getRow(33).getCell(1).getNumericCellValue();
                    double p19Val = firstSheet.getRow(34).getCell(1).getNumericCellValue();


                    int p1ExtractionMethod = this.getExtractionMethodId(firstSheet.getRow(17).getCell(3).getStringCellValue());
                    int p13ExtractionMethod = this.getExtractionMethodId(firstSheet.getRow(18).getCell(3).getStringCellValue());
                    int p14ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(19).getCell(3).getStringCellValue());
                    int p15ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(20).getCell(3).getStringCellValue());
                    int p2ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(21).getCell(3).getStringCellValue());
                    int p3ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(22).getCell(3).getStringCellValue());
                    int p4ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(23).getCell(3).getStringCellValue());
                    int p5ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(24).getCell(3).getStringCellValue());
                    int p6ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(25).getCell(3).getStringCellValue());
                    int p7ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(26).getCell(3).getStringCellValue());
                    int p8ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(27).getCell(3).getStringCellValue());
                    int p9ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(28).getCell(3).getStringCellValue());
                    int p10ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(29).getCell(3).getStringCellValue());
                    int p11ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(30).getCell(3).getStringCellValue());
                    int p12ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(31).getCell(3).getStringCellValue());
                    int p16ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(32).getCell(3).getStringCellValue());
                    int p17ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(33).getCell(3).getStringCellValue());
                    int p19ExtractionMethod  = this.getExtractionMethodId(firstSheet.getRow(34).getCell(3).getStringCellValue());

                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,1,p1Val,p1ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,2,p2Val,p2ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,3,p3Val,p3ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,4,p4Val,p4ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,5,p5Val,p5ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,6,p6Val,p6ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,7,p7Val,p7ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,8,p8Val,p8ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,9,p9Val,p9ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,10,p10Val,p10ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,11,p11Val,p11ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,12,p12Val,p12ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,13,p13Val,p13ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,14,p14Val,p14ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,15,p15Val,p15ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,16,p16Val,p16ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,17,p17Val,p17ExtractionMethod));
                    labAnalysisResultList.add(new SoilLabAnalysisResult(soil_analysis_id,19,p19Val,p19ExtractionMethod));


                    //insert to lab_analysis_results schema
                    LabAnalysisResultDao larDao = new LabAnalysisResultDaoImpl();
                    larDao.insertAllSoil(labAnalysisResultList);

                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("wrong read parameters - lab analysis");
                }

            }
            else {
                System.out.println("wrong 2 row selected");
            }
            //close file input stream
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soilAnalysisId;
    }

    LocalDate getLocalDate(Cell cell){
        if (DateUtil.isCellDateFormatted(cell)){
            Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
            return date.toInstant().atZone((ZoneId.systemDefault())).toLocalDate();
            //System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));
        }
        System.out.println("problem at getLocalDate");
        return null;
    }

     Boolean getIsActive(String s){
        if(s.toLowerCase().equals("yes") || s.toLowerCase().equals("true")) {
            return true;
        }else if(s.toLowerCase().equals("no") || s.toLowerCase().equals("false")) {
            return false;
        }else {
            System.out.println("wrong in_active filed - water analysis");
        }
        return false;
    }

    int getSoilTypeId(String cropName){
        SoilDao soilDao = new SoilDaoImpl();
        List<Soil> soils = soilDao.selectAll();
        for (Soil soil : soils){
            if(soil.getName().toLowerCase().equals(cropName.toLowerCase())){
                return soil.getId();
            }
        }
        System.out.println("problem at getSoilTypeId");
        return -1;
    }

    int getLayerDepthId(String layerDepth){
        layer_depth_typeDao ldtDao = new layer_depth_typeDaoImpl();
        List<layer_depth_type> layers = ldtDao.selectAll();
        for (layer_depth_type layer : layers){
            if(layer.getLayer_depth_name().toLowerCase().equals(layerDepth.toLowerCase())){
                return  layer.getLayer_depth_id();
            }
        }
        System.out.println("problem at getLayerDepthId");
        return -1;

    }

    private int getExtractionMethodId(String s) {
        if (this.emList == null) {
            ExtractionMethodDao emd = new ExtractionMethodDaoImpl();
            this.emList = emd.selectAll();
        }
        for (ExtractionMethod em : emList){
            if (s.toLowerCase().equals(em.getExtraction_method_desc().toLowerCase())){
                return em.getExtraction_method_id();
            }
        }
        if (!s.equals("")){
            System.out.println("Extraction method ID - problem : " + s);
        }
        return 0;
    }


}
