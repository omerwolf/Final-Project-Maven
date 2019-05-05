package Model;

import DB.Entites.Soil;
import javafx.stage.Stage;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrganicMatterContribution {

    public OrganicMatterContribution() {

    }

    public Nutrients organicMatterContribution(Parameters p, Nutrients n) {

        //if check (once pre season soil excel will be in the DB, and if labeled "yes")
        //the following lines will take the data from the DB, for now, random values are assigned.
        double organicMatter = 0.012; //will be changed once excel will be in DB
        double layerDepth = 30/100; // divide value (taken from DB) by 100
        if (layerDepth == 0) { //null
            layerDepth = 0.3;
        }

        double[] somNutrients = {100,15*2.29,15};
        double oc = 0.58;
        Soil soil = n.getSoil();
        //active and yes check
        double db = 1000; //* bulk density in pre soil
        //else
        System.out.println("default is " + soil.getDefualtBulkDensity());
        //db = 1000*soil.getDefualtBulkDensity(); // get from table
        db = 1000*soil.getDefualtBulkDensity();
        List<StageDate> stageDateList= p.getStageDates();
        Set<Integer> months = uniqueMonths(stageDateList);
        for (Integer i:months) {
            System.out.println("unique month: " +i);
        }
        double meanTemp = 26.5;//need to get temp from climate (excel to db?)
        double decomosingRate;
        if (meanTemp < 15) {
            decomosingRate = soil.getSomDecompLow();
        }
        else if (meanTemp < 25) {
            decomosingRate = soil.getSomDecompModerate();
        }
        else {
            decomosingRate = soil.getSomDecompHigh();
        }

        double duration = 0.3288; //will be changed

        double soilWeight = layerDepth * db * 10;
        double soilOc = oc * soilWeight * organicMatter;
        double annualOcDecomp = soilOc * decomosingRate;
        double ocDecomp = annualOcDecomp * duration;
        System.out.println(soilWeight+ " "  + soilOc +" " +annualOcDecomp + " " +ocDecomp);
        double[] nps = new double[3];
        for (int i=0;i<somNutrients.length;i++) {
            nps[i] = somNutrients[i] * ocDecomp;
            System.out.println(nps[i]);
        }

        List<Integer> som = new ArrayList<>(Collections.nCopies(n.getName().size(),0));
        for (int i=0;i<n.getName().size() ;i++) {
            System.out.println(n.getName().get(i));
        }
        som.set(0,(int)Math.round(-nps[0]));
        som.set(1,(int)Math.round(-nps[1]));
        som.set(5,(int)Math.round(-nps[2]));
        for (int i=0;i<som.size() ;i++) {
            System.out.println(som.get(i));
        }

        n.getSoilNutrients().setSom(som);
        return n;
    }

    public Set<Integer> uniqueMonths(List<StageDate> stageDateList) {
        Set<Integer> months = new LinkedHashSet<>();
        for (StageDate d:stageDateList) {
            String date = d.getStageDate();
            //System.out.println(date);
            Pattern pattern = Pattern.compile("/(.*?)/");
            Matcher matcher = pattern.matcher(date);
            while (matcher.find()) {
                months.add(Integer.parseInt(matcher.group(1)));
            }
        }
        return months;
    }
}
