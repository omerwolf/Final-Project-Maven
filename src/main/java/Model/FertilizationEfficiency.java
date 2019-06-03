package Model;

import DB.Dao.FertilizationMethodEfficiencyDao;
import DB.DaoImpl.FertilizationMethodEfficiencyDaoImpl;
import DB.Entites.FertilizationMethodEfficiency;
import DB.Entites.fertilization_method;
import Model.Climate.ERClimate;
import Model.Climate.MonthClimate;
import Model.WriteOutput.NutrientsOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FertilizationEfficiency {

    public FertilizationEfficiency() {

    }

    public Nutrients calculateFertilizationEfficiency(Parameters p, Nutrients n) {
        NutrientsOutput adjN = getNutrientOutput(n,"pH_Adjusted");
        List<NutrientsOutput> nutrientsOutputList = new ArrayList<>();
        double [] adjArray = {Math.round(adjN.getN()),Math.round(adjN.getP205()),Math.round(adjN.getK20()), Math.round(adjN.getCa0()),
                Math.round(adjN.getMg0()),Math.round(adjN.getS()), Math.round(adjN.getFe()), Math.round(adjN.getB()),
                Math.round(adjN.getMn()),Math.round(adjN.getZn()),Math.round(adjN.getCu()),Math.round(adjN.getMo())};
        double [] baseDressing = new double[12];
        double [] baseFactor = new double[12];
        double [] fertilization = new double[12];
        fertilization_method fm = p.getUi().getSelectedFertilizationMethod();
        int fertMethodId = fm.getFert_method_id();
        FertilizationMethodEfficiencyDao fmed = new FertilizationMethodEfficiencyDaoImpl();
        List<FertilizationMethodEfficiency> fmList = fmed.selectAll();
        List<Double> fertEfficientValues = new ArrayList<>();
        List<Double> baseEfficiency = new ArrayList<>();
        System.out.println("fert method efficiency");
        for (FertilizationMethodEfficiency fme:fmList) {
            if (fme.getFert_method_id() == fertMethodId) {
                fertEfficientValues.add(fme.getFert_method_efficiency());
                System.out.print(fme.getFert_method_efficiency() + ", ");
            }
            if (fme.getFert_method_id() == 1) { //1 is base efficiency (soil application)
                baseEfficiency.add(fme.getFert_method_efficiency());
                System.out.print(fme.getFert_method_efficiency() + ", ");
            }
        }

        if (p.getUi().getSelectedBaseDressing()) {
            //int minMonth;
            StageDate plantingMonth = p.getStageDates().get(0);
            String plantingMonthString = plantingMonth.getStageDate();
            Pattern pattern = Pattern.compile("/(.*?)/");
            Matcher matcher = pattern.matcher(plantingMonthString);
            int plantMonth = 0;
            while (matcher.find()) {
                plantMonth = Integer.parseInt(matcher.group(1));
            }
            System.out.println("month is: " +plantMonth);
            List<Integer> rainRegimeMonths = calculateRainMonths(plantMonth);
            ERClimate erclimate = new ERClimate();
            double meanRain = 0.0;
            for (Integer rainMonth:rainRegimeMonths) {
                MonthClimate mc = erclimate.getMonth(rainMonth);
                meanRain += mc.getRain();
            }
            meanRain = meanRain/rainRegimeMonths.size();
            System.out.println(meanRain);
            double rainEffect;
            if (meanRain > 150) {
                rainEffect = n.getSoil().getRainEffect();
            }
            else {
                rainEffect = 0;
            }
            baseFactor[0] = n.getSoil().getnPrecent() * (1-rainEffect);
            baseFactor[1] = n.getSoil().getpPrecent() * (1-rainEffect);
            baseFactor[2] = n.getSoil().getkPrecent() * (1-rainEffect);
            for (int i=0; i<baseFactor.length ;i++) {
                baseDressing[i] = adjArray[i] * baseFactor[i];
                fertilization[i] = adjArray[i] * (1-baseFactor[i]);
            }
        }
        else {
            for (int i=0;i<baseFactor.length;i++) {
                fertilization[i] = adjArray[i] * (1-baseFactor[i]);
            }
        }
        double[] actualBaseDressing = new double[baseDressing.length];
        double[] actualFertilization = new double[baseDressing.length];
        for (int i=0;i<actualBaseDressing.length;i++) {
            actualBaseDressing[i] = baseDressing[i]/baseEfficiency.get(i);
            actualFertilization[i] = fertilization[i]/fertEfficientValues.get(i);
        }

        for (int i=0;i<12;i++) {
            baseDressing[i] = Math.round(baseDressing[i]);
            fertilization[i] = Math.round(fertilization[i]);
            actualBaseDressing[i] = Math.round(actualBaseDressing[i]);
            actualFertilization[i] = Math.round(actualFertilization[i]);
        }
        String [] labels = {"Adj_Nutrients", "Base_Dressing", "Fertilization", "Actual_Base_Dressing", "Actual_Fertilization"};
        NutrientsOutput adjNutrientsOutput = toNutrientOutput(adjArray,labels[0]);
        NutrientsOutput baseDressingOutput = toNutrientOutput(baseDressing,labels[1]);
        NutrientsOutput fertilizationOutpit = toNutrientOutput(fertilization,labels[2]);
        NutrientsOutput actualBaseDressingOutput = toNutrientOutput(actualBaseDressing,labels[3]);
        NutrientsOutput actualFertilizationOutput = toNutrientOutput(actualFertilization,labels[4]);
        nutrientsOutputList.add(adjNutrientsOutput);
        nutrientsOutputList.add(baseDressingOutput);
        nutrientsOutputList.add(fertilizationOutpit);
        nutrientsOutputList.add(actualBaseDressingOutput);
        nutrientsOutputList.add(actualFertilizationOutput);
        n.getPreSeason().setActualNutrients(nutrientsOutputList);
        System.out.println(nutrientsOutputList);
        return n;


    }

    public List<Integer> calculateRainMonths(int plantMonth) {
        List<Integer> rainMonths = new ArrayList<>();
        rainMonths.add(plantMonth);
        if (plantMonth >=3) {
            rainMonths.add(plantMonth - 1);
            rainMonths.add(plantMonth - 2);
        }
        else if (plantMonth >=2) {
                rainMonths.add(plantMonth - 1);
                rainMonths.add(12);
        }
        else {
            rainMonths.add(12);
            rainMonths.add(11);
        }
        System.out.println(rainMonths.get(0) + " " + rainMonths.get(1) + " " + rainMonths.get(2));
        return rainMonths;
    }

    public NutrientsOutput getNutrientOutput(Nutrients n,String rowName) {
        List<NutrientsOutput> nlist = n.getPreSeason().getAdjNutrients();
        NutrientsOutput nutrientsOutput = null;
        for (NutrientsOutput no:nlist) {
            if (no.getStageName().equals(rowName)) {
                nutrientsOutput = no;
                break;
            }
        }
        return nutrientsOutput;
    }
    public NutrientsOutput toNutrientOutput(double [] output, String name) {
        NutrientsOutput nutrientsOutput = new NutrientsOutput(name,output[0],output[1],output[2],
                output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10], output[11]);
        return nutrientsOutput;
    }

}
