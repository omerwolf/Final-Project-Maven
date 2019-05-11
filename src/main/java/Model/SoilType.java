package Model;

import DB.Dao.SoilDao;
import DB.DaoImpl.SoilDaoImpl;
import DB.Entites.Soil;

public class SoilType {

    private UserInput ui;

    public SoilType() {

    }
    public SoilType(UserInput ui) {
        this.ui = ui;
    }

    public Nutrients soilType(Parameters p, Nutrients n) {
        //if lab analysis is active, read soil info from there (should be in the db at this stage).
        int soilId = p.getSa().getSoil_type_id();
        SoilDao soilDao = new SoilDaoImpl();
        Soil soil = soilDao.selectById(soilId);
        n.setSoil(soil);
        //else
        n.setSoil(p.getUi().getSelectedSoil()); //take soil from simulation data
        return n;
    }
}
