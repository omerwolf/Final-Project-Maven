package Model;

import DB.Dao.Dao;
import DB.DaoImpl.pheonological_stageDaoImpl;
import DB.Entites.pheonological_stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * calculates the dates for each stage of the crop and their names,
 * and the total duration of the crop's growth.
 */
public class StageDate {

    public StageDate() {

    }

    /**
     * takes the initial date from the user input (if exists, otherwise takes current day),
     * and calculates the dates and names of each stage during the crop's growth.
     * it also calculates the total duration of the crop's growth.
     * they are inserted to the parameters class(which was received as an input) and then returned.
     * @param parameters - the parameters data.
     * @return parameters - the same class, with updated members.
     */
    public Parameters stageDate(Parameters parameters) {
        //checks user input date. if empty, takes the current day
        LocalDate ld = parameters.getUi().getSelectedDate();
        if (ld == null) {
            ld = LocalDate.now();
        }
        //change format from yyyy/mm/dd to dd/mm/yyyy
        DateTimeFormatter formatteer = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = ld.format(formatteer);  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(formattedString));
        }
        catch (ParseException e) {
            System.out.println("invalid date format");
        }
        Dao<pheonological_stage> p = new pheonological_stageDaoImpl();
        List<pheonological_stage> pheonologicalStageList= p.selectAll();
        List<String> stageName = new ArrayList<>();
        List<Integer> stageDuration = new ArrayList<>();
        stageDuration.add(0);
        int duration = 0;
        //add the names of each stage, and calculate the duration of each stage
        for (pheonological_stage ps:pheonologicalStageList) {
            if (ps.getCrop_id() == parameters.getUi().getSelectedCrop().getId()) {
                stageName.add(ps.getPheonological_stage_desc());
                stageDuration.add(ps.getPheonological_stage_duration_days());
                duration += ps.getPheonological_stage_duration_days();
            }
        }
        //sets the crop growth duration in parameters
        parameters.setDuration(duration);
        System.out.println("the duration total is: " +duration);
        List<String> dates = new ArrayList<>();
        //calculate the dates for each stage
        for (int i=0;i<stageName.size();i++) {
            c.add(Calendar.DATE, stageDuration.get(i));
            formattedString = sdf.format(c.getTime());
            dates.add(formattedString);
        }
        List<CropStage> cropStageList = new ArrayList<>();
        //add the dates for each stage and their names to a list
        for (int i=0; i<dates.size();i++) {
            CropStage sd = new CropStage();
            sd.setStageDate(dates.get(i));
            sd.setStageName(stageName.get(i));
            cropStageList.add(sd);
        }
        //sets the crop stage list in parameters class
        parameters.setCropStages(cropStageList);
        System.out.println("end of stagedate");
        return parameters;
    }
}
