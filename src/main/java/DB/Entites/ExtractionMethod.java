package DB.Entites;

/**
 * represents a record in the `extraction_methods` table
 * in the database.
 */
public class ExtractionMethod {
    private int extraction_method_id;
    private String extraction_method_desc;

    /**
     * default constructor
     */
    public ExtractionMethod() {
    }

    /**
     * creates an ExtractionMethod record.
     * @param extraction_method_id - extraction method's id
     * @param extraction_method_desc - the name of the extraction method
     */
    public ExtractionMethod(int extraction_method_id, String extraction_method_desc) {
        this.extraction_method_id = extraction_method_id;
        this.extraction_method_desc = extraction_method_desc;
    }

    public int getExtraction_method_id() {
        return extraction_method_id;
    }

    public void setExtraction_method_id(int extraction_method_id) {
        this.extraction_method_id = extraction_method_id;
    }

    public String getExtraction_method_desc() {
        return extraction_method_desc;
    }

    public void setExtraction_method_desc(String extraction_method_desc) {
        this.extraction_method_desc = extraction_method_desc;
    }

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
    @Override
    public String toString() {
        return "ExtractionMethod{" +
                "extraction_method_id=" + extraction_method_id +
                ", extraction_method_desc='" + extraction_method_desc + '\'' +
                '}';
    }
}
