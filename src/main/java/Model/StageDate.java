package Model;
import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StageDate {

    String stageName;
    String stageDate;
    public StageDate(){

    }

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
        pheonological_stageDao p = new pheonological_stageDaoImpl();
        List<pheonological_stage> pheonologicalStageList= p.selectAll();
        List<String> stageName = new ArrayList<>();
        List<Integer> stageDuration = new ArrayList<>();
        stageDuration.add(0);
        int duration = 0;
        for (pheonological_stage ps:pheonologicalStageList) {
            if (ps.getCrop_id() == parameters.getUi().getSelectedCrop().getId()) { //should be updated when user input includes stage date
                stageName.add(ps.getPheonological_stage_desc());
                stageDuration.add(ps.getPheonological_stage_duration_days());
                duration += ps.getPheonological_stage_duration_days();
            }
        }
        //add duration to parameters class
        parameters.setDuration(duration);
        System.out.println("the duration total is: " +duration);
        List<String> dates = new ArrayList<>();
        //calculate the dates for each stage
        for (int i=0;i<stageName.size();i++) {
            c.add(Calendar.DATE, stageDuration.get(i));
            formattedString = sdf.format(c.getTime());
            dates.add(formattedString);
        }
        List<StageDate> stageDateList= new ArrayList<>();
        //add the dates for each stage and their names to a list
        for (int i=0; i<dates.size();i++) {
            StageDate sd = new StageDate();
            sd.setStageDate(dates.get(i));
            sd.setStageName(stageName.get(i));
            stageDateList.add(sd);
        }
        parameters.setStageDates(stageDateList);
        System.out.println("end of stagedate");
        return parameters;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDate() {
        return stageDate;
    }

    public void setStageDate(String stageDate) {
        this.stageDate = stageDate;
    }
}
