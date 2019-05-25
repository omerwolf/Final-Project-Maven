package DB.ExcelReadWrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DB.Entites.ParameterPhEffect;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * the class reads from excel the parameter ph effect table data.
 */
public class ExcelReadParameterPhEffect {
    static String fileName = "src\\main\\resources\\parameter_ph_effect.xlsx";

    /**
     * the constructor.
     */
    public ExcelReadParameterPhEffect() {

    }

    /**
     * reads the parameter ph effect data from the excel,
     * creates records, and add them to a list, which is then returned.
     * @return parameterPhEffectList - a list of parameter ph effect records
     * to be added to the database.
     */
    public List<ParameterPhEffect> readExcelData() {
        List<ParameterPhEffect> parameterPhEffectList = new ArrayList<ParameterPhEffect>();

        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (fileName.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {

                    Integer effectId = null;
                    Integer parameterId = null;
                    Integer rangeId = null;
                    Double effect = null;

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        //Get the Cell object
                        Cell cell = cellIterator.next();

                        //check the cell type and process accordingly
                        if (cell.getCellType() != Cell.CELL_TYPE_FORMULA) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    if (effectId == null) {
                                        effectId = (int) cell.getNumericCellValue();
                                        System.out.println("effectId is " + effectId);
                                    } else if (parameterId == null) {
                                        //2nd column
                                        parameterId = (int) cell.getNumericCellValue();
                                        System.out.println("parameterId is " + parameterId);
                                    } else if (rangeId == null) {
                                        rangeId = (int) cell.getNumericCellValue();
                                        System.out.println("rangeId is " + rangeId);
                                    } else if (effect == null) {
                                        effect = cell.getNumericCellValue();
                                        System.out.println("effect is " + effect);
                                    } else {
                                        System.out.println("Random data::" + cell.getNumericCellValue());
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    //random data, leave it
                                    System.out.println("Random data::" + cell.getStringCellValue());

                            }//end of cell iterator
                        }
                        //used for cells that are calculated with a formula
                        else {
                            switch (cell.getCachedFormulaResultType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    if (parameterId == null) {
                                        //2nd column
                                        parameterId = (int) cell.getNumericCellValue();
                                        System.out.println("parameterId is " + parameterId);
                                    } else if (rangeId == null) {
                                        rangeId = (int) cell.getNumericCellValue();
                                        System.out.println("rangeId is " + rangeId);
                                    } else {
                                        System.out.println("Random data::" + cell.getNumericCellValue());
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    //random data, leave it
                                    System.out.println("Random data::" + cell.getStringCellValue());

                            }
                        }

                    } //end of rows iterator
                    if (effectId != null && parameterId != null && rangeId != null
                            && effect != null) {
                        ParameterPhEffect ppe = new ParameterPhEffect(effectId.intValue(), parameterId.intValue()
                                , rangeId.intValue(), effect);
                        parameterPhEffectList.add(ppe);
                    } else {
                        System.out.println("row number " + row.getRowNum() + " have null!!");
                    }
                } //end of sheets for loop
                //close file input stream
                fis.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return parameterPhEffectList;
    }
}
