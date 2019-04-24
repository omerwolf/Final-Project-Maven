package Model;

import DB.Entites.*;

import java.io.File;
import java.time.LocalDate;

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

    private File selectedSoilAnalysisFile;
    private File selectedTissueAnalysisFile;
    private File selectednWaterAnalysisFile;

    private LocalDate selectedDate;

    public UserInput(Crop selectedCrop, variety_type selectedVarType, Soil selectedSoil, Double selectedexpectedYield,
                     int selectedNCredit, IrrigationMethod selectedIrrigationMethod, Double selectedIrrigationVolume,
                     fertilization_method selectedFertilizationMethod, Boolean selectedBaseDressing,
                     Double selectedSoilCorrection, Double selectedSoilPH, File selectedSoilAnalysisFile,
                     File selectedTissueAnalysisFile, File selectednWaterAnalysisFile, LocalDate selectedDate) {
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
        this.selectedSoilAnalysisFile = selectedSoilAnalysisFile;
        this.selectedTissueAnalysisFile = selectedTissueAnalysisFile;
        this.selectednWaterAnalysisFile = selectednWaterAnalysisFile;
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

    public File getSelectedSoilAnalysisFile() {
        return selectedSoilAnalysisFile;
    }

    public File getSelectedTissueAnalysisFile() {
        return selectedTissueAnalysisFile;
    }

    public File getSelectednWaterAnalysisFile() {
        return selectednWaterAnalysisFile;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }
}