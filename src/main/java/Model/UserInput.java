package Model;

import DB.Entites.*;

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
    private Double selectedSoilPH;

    public UserInput(Crop selectedCrop, variety_type selectedVarType, Soil selectedSoil, Double selectedexpectedYield,
                     int selectedNCredit, IrrigationMethod selectedIrrigationMethod,
                     Double selectedIrrigationVolume, fertilization_method selectedFertilizationMethod,
                     Boolean selectedBaseDressing, Double selectedSoilPH) {
        this.selectedCrop = selectedCrop;
        this.selectedVarType = selectedVarType;
        this.selectedSoil = selectedSoil;
        this.selectedexpectedYield = selectedexpectedYield;
        this.selectedNCredit = selectedNCredit;
        this.selectedIrrigationMethod = selectedIrrigationMethod;
        this.selectedIrrigationVolume = selectedIrrigationVolume;
        this.selectedFertilizationMethod = selectedFertilizationMethod;
        this.selectedBaseDressing = selectedBaseDressing;
        this.selectedSoilPH = selectedSoilPH;
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

    public Double getSelectedSoilPH() {
        return selectedSoilPH;
    }
}
