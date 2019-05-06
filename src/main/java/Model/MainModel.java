package Model;

import Analysis.LabAnalysisResults.*;

import java.util.List;

public class MainModel {

    public static void main(String[] args) {
        //UserInput ui = new UserInput()
        Model model = new Model(111,19,null);
        //model.init();

        LabAnalysisResultDao lard = new LabAnalysisResultDaoImpl();
        List<SoilLabAnalysisResult> soilLabAnalysisResults = lard.selectAllSoilById(111);
        for (SoilLabAnalysisResult s : soilLabAnalysisResults) {
            System.out.println(s);
            System.out.println("///////////////////");
        }

        System.out.println("******************");

        List<WaterLabAnalysisResult> waterLabAnalysisResults = lard.selectAllWaterById(19);
        for (WaterLabAnalysisResult w : waterLabAnalysisResults) {
            System.out.println(w);
            System.out.println("///////////////////");
        }


    }
}
