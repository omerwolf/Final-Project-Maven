package Model;
import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StageDate {

    private UserInput ui;
    String stageName;
    String stageDate;
    public StageDate(){

    }
    public StageDate(UserInput ui) {
        this.ui = ui;
    }

    public void stageDate(Parameters parameters) {
        //needs to add planting date for user input
        String dt = "02/06/2018";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        }
        catch (ParseException e) {
            System.out.println("invalid date format");
        }
        pheonological_stageDao p = new pheonological_stageDaoImpl();
        List<pheonological_stage> pheonologicalStageList= p.selectAll();
        List<String> stageName = new ArrayList<>();
        List<Integer> stageDuration = new ArrayList<>();
        stageDuration.add(0);
        for (pheonological_stage ps:pheonologicalStageList) {
            if (ps.getCrop_id() == 8) { //should be updated when user input includes stage date
                stageName.add(ps.getPheonological_stage_desc());
                stageDuration.add(ps.getPheonological_stage_duration_days());
            }
        }
        List<String> dates = new ArrayList<>();
        //calculate the dates for each stage
        for (int i=0;i<stageName.size();i++) {
            c.add(Calendar.DATE, stageDuration.get(i));
            dt = sdf.format(c.getTime());
            dates.add(dt);
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
