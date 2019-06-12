package Model;

import DB.Dao.Dao;
import DB.DaoImpl.SoilDaoImpl;
import DB.Entites.Soil;

/**
 * the class calculates the soil type.
 */
public class SoilType {

    private UserInput ui;

    public SoilType() {

    }

    /**
     * the constructor receives the user input.
     * @param ui - the user input
     */
    public SoilType(UserInput ui) {
        this.ui = ui;
    }

    /**
     * retrieves the soil type, either from the db (if lab analysis is active)
     * or the user input, and updates the nutrients data.
     * @param p - the parameters data.
     * @param n - the nutrients data.
     * @return - the nutrients data, updated with the calculated soil type.
     */
    public Nutrients soilType(Parameters p, Nutrients n) {
        //if lab analysis is active, read soil info from there (should be in the db at this stage).
        int soilId = p.getSa().getSoil_type_id();
        Dao<Soil> soilDao = new SoilDaoImpl();
        Soil soil = soilDao.selectById(soilId);
        n.setSoil(soil);
        //else
        n.setSoil(p.getUi().getSelectedSoil()); //take soil from simulation data
        return n;
    }
}
