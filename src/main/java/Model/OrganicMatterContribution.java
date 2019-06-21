package Model;

import DB.Dao.Dao;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.Entites.Soil;
import DB.Entites.layer_depth_type;
import Model.Climate.ERClimate;
import Model.Climate.MonthClimate;
import Model.WriteOutput.NutrientsOutput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the class is responsible for the calculation of the omc (organic matter contribution).
 */
public class OrganicMatterContribution {

    public OrganicMatterContribution() {

    }

    /**
     * calculates the organic matter contribution. it adds it to
     * the adjusted nutrient table, and then returns the updated nutrients data.
     * @param p - the parameters data.
     * @param n - the nutrients data.
     * @return n - the updated nutrients data.
     */
    public Nutrients organicMatterContribution(Parameters p, Nutrients n) {

        if (p.getSa().isIs_active()) {
            double organicMatter = p.getSa().getOrganic_matter();
            System.out.println("organic matter is: " + organicMatter);
            //extracting the range for the depth
            int layerDepthId = p.getSa().getLayer_depth_id();
            System.out.println("layer id is: " + layerDepthId);
            Dao<layer_depth_type> ldtd = new layer_depth_typeDaoImpl();
            layer_depth_type ldt = ldtd.selectById(layerDepthId);
            System.out.println("max is: " +ldt.getLayer_max());
            System.out.println("min is: " +ldt.getLayer_min());
            double layerAvg = (ldt.getLayer_min() + ldt.getLayer_max()) / 2;
            Double layerDepth = layerAvg / 100; // divide value (taken from DB) by 100
            if (layerDepth == null) {
                layerDepth = 0.3;
            }

            double[] somNutrients = {100, 15 * 2.29, 15};
            double oc = 0.0058; //0.58 in matlab, but during code treated as 0.0058
            Soil soil = n.getSoil();
            //active and yes check
            double db; //* bulk density in pre soil
            System.out.println("pre soil bulk is: " + p.getSa().getBulk_density());
            if (p.getSa().isIs_active() && p.getSa().getBulk_density() != null) {
                db = 1000 * p.getSa().getBulk_density();
            } else {
                db = 1000 * soil.getDefualtBulkDensity();
            }
            List<CropStage> cropStageList = p.getCropStages();
            Set<Integer> uniqueMonths = uniqueMonths(cropStageList);
            for (Integer i : uniqueMonths) {
                System.out.println("unique month: " + i);
            }
            //calculating the mean temperature
            ERClimate erClimate = new ERClimate();
            double meanTemp = 0.0;
            for (Integer monthId : uniqueMonths) {
                MonthClimate mc = erClimate.getMonth(monthId);
                meanTemp += mc.getTemp();
            }
            meanTemp = meanTemp / uniqueMonths.size();
            System.out.println("mean temp is: " + meanTemp);
            double decomosingRate;
            //get decomposing rate based on the calculated meanTemp value
            if (meanTemp < 15) {
                decomosingRate = soil.getSomDecompLow();
            } else if (meanTemp < 25) {
                decomosingRate = soil.getSomDecompModerate();
            } else {
                decomosingRate = soil.getSomDecompHigh();
            }

            System.out.println("layer depth is: " + layerDepth);
            System.out.println("db is: " + db);
            double duration = (p.getDuration()) / 365.0;
            System.out.println("duration is: " + duration);
            double soilWeight = layerDepth * db * 10;
            double soilOc = oc * soilWeight * organicMatter;
            double annualOcDecomp = soilOc * decomosingRate;
            double ocDecomp = annualOcDecomp * duration;
            System.out.println("soil weight: " + soilWeight + " soil oc: " + soilOc
                    + " annualocdecomp: " + annualOcDecomp + " ocdecomp: " + ocDecomp);
            double[] nps = new double[3];
            for (int i = 0; i < somNutrients.length; i++) {
                nps[i] = somNutrients[i] * ocDecomp;
                System.out.println(nps[i]);
            }
            //soil organic matter(som) calculation
            List<Double> som = new ArrayList<>(Collections.nCopies(n.getName().size(), 0.0));
            for (int i = 0; i < n.getName().size(); i++) {
                System.out.println(n.getName().get(i));
            }
            Integer somN = (int) Math.round(-nps[0]);
            Integer somP = (int) Math.round(-nps[1]);
            Integer somS = (int) Math.round(-nps[2]);
            som.set(0, Double.valueOf(somN));
            som.set(1, Double.valueOf(somP));
            som.set(5, Double.valueOf(somS));
            System.out.println("som values: ");
            for (int i = 0; i < som.size(); i++) {
                System.out.println(som.get(i));
            }

            //adding som to nutrients adj output table
            List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
            NutrientsOutput nutrientsOutput = new NutrientsOutput("SOM", som);
            nutrientsOutputList.add(nutrientsOutput);
            n.getPreSeason().setAdjNutrients(nutrientsOutputList);
        }
        return n;
    }

    /**
     * receives the crop stage list and returns a set that contains
     * the unique months in which a stage is started.
     * note: it means that if two or more stages begin in the same month,
     * their month id value will be taken only once.
     * @param cropStageList - list containing info about each crop start date and name.
     * @return months - a set of unique months.
     */
    public Set<Integer> uniqueMonths(List<CropStage> cropStageList) {
        Set<Integer> months = new LinkedHashSet<>();
        for (CropStage d: cropStageList) {
            String date = d.getStageDate();
            Pattern pattern = Pattern.compile("/(.*?)/");
            Matcher matcher = pattern.matcher(date);
            while (matcher.find()) {
                months.add(Integer.parseInt(matcher.group(1)));
            }
        }
        return months;
    }
}
