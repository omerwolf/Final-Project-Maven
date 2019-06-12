package Model;

import DB.Entites.*;

import java.io.File;
import java.time.LocalDate;

/**
 * contains all the info that the user put before the beginning of a season.
 */
public class UserInput {
    private Crop selectedCrop;
    private variety_type selectedVarType;
    private Soil selectedSoil;
    private Double selectedexpectedYield;
    private int selectedNCredit;
    private IrrigationMethod selectedIrrigationMethod;
    private Double selectedIrrigationVolume;
    private fertilization_method selectedFertilizationMethod;
    private Boolean selectedBaseDressing;
    private Double selectedSoilCorrection;
    private Double selectedSoilPH;
    private String runName;


    private LocalDate selectedDate;

    /**
     * creates a class of the user input, by receiving all the necessary input
     * from the user.
     * @param runName - current run name.
     * @param selectedCrop - the crop the user selected to grow.
     * @param selectedVarType - the variety type of the crop the user selected to grow.
     * @param selectedSoil - the soil on which the crop will grow.
     * @param selectedexpectedYield - the expected yield of the crop (values ranges depends on on the
     *                              crop and variety type selected).
     * @param selectedNCredit - the amount of n credit from previous crop.
     * @param selectedIrrigationMethod - the irrigation method the user selected.
     * @param selectedIrrigationVolume - the irrigation volume selected.
     * @param selectedFertilizationMethod - the fertilization method the user selected.
     * @param selectedBaseDressing - the amount of base dressing.
     * @param selectedSoilCorrection - the soil correction value.
     * @param selectedSoilPH - the amount of ph (values between 0-14)
     * @param selectedDate - the date the user selected to start the crop's growth.
     */
    public UserInput(String runName,Crop selectedCrop, variety_type selectedVarType, Soil selectedSoil, Double selectedexpectedYield,
                     int selectedNCredit, IrrigationMethod selectedIrrigationMethod, Double selectedIrrigationVolume,
                     fertilization_method selectedFertilizationMethod, Boolean selectedBaseDressing,
                     Double selectedSoilCorrection, Double selectedSoilPH, LocalDate selectedDate) {
        this.selectedCrop = selectedCrop;
        this.selectedVarType = selectedVarType;
        this.selectedSoil = selectedSoil;
        this.selectedexpectedYield = selectedexpectedYield;
        this.selectedNCredit = selectedNCredit;
        this.selectedIrrigationMethod = selectedIrrigationMethod;
        this.selectedIrrigationVolume = selectedIrrigationVolume;
        this.selectedFertilizationMethod = selectedFertilizationMethod;
        this.selectedBaseDressing = selectedBaseDressing;
        this.selectedSoilCorrection = selectedSoilCorrection;
        this.selectedSoilPH = selectedSoilPH;
        this.runName = runName;
        this.selectedDate = selectedDate;
    }

    public Crop getSelectedCrop() {
        return selectedCrop;
    }

    public variety_type getSelectedVarType() {
        return selectedVarType;
    }

    public Soil getSelectedSoil() {
        return selectedSoil;
    }

    public Double getSelectedexpectedYield() {
        return selectedexpectedYield;
    }

    public int getSelectedNCredit() {
        return selectedNCredit;
    }

    public IrrigationMethod getSelectedIrrigationMethod() {
        return selectedIrrigationMethod;
    }

    public Double getSelectedIrrigationVolume() {
        return selectedIrrigationVolume;
    }

    public fertilization_method getSelectedFertilizationMethod() {
        return selectedFertilizationMethod;
    }

    public Boolean getSelectedBaseDressing() {
        return selectedBaseDressing;
    }

    public Double getSelectedSoilCorrection() {
        return selectedSoilCorrection;
    }

    public Double getSelectedSoilPH() {
        return selectedSoilPH;
    }

    public String getRunName() {
        return runName;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    /**
     * overrides toString method in order to print the user input
     * field names and values.
     * @return climate's field names and values.
     */
    @Override
    public String toString() {
        return "UserInput{" +
                "selectedCrop=" + selectedCrop +
                ", selectedVarType=" + selectedVarType +
                ", selectedSoil=" + selectedSoil +
                ", selectedexpectedYield=" + selectedexpectedYield +
                ", selectedNCredit=" + selectedNCredit +
                ", selectedIrrigationMethod=" + selectedIrrigationMethod +
                ", selectedIrrigationVolume=" + selectedIrrigationVolume +
                ", selectedFertilizationMethod=" + selectedFertilizationMethod +
                ", selectedBaseDressing=" + selectedBaseDressing +
                ", selectedSoilCorrection=" + selectedSoilCorrection +
                ", selectedSoilPH=" + selectedSoilPH +
                ", runName='" + runName + '\'' +
                ", selectedDate=" + selectedDate +
                '}';
    }
}