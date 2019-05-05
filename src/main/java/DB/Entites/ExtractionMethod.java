package DB.Entites;

public class ExtractionMethod {
    private int extraction_method_id;
    private String extraction_method_desc;

    public ExtractionMethod() {
    }

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

    @Override
    public String toString() {
        return "ExtractionMethod{" +
                "extraction_method_id=" + extraction_method_id +
                ", extraction_method_desc='" + extraction_method_desc + '\'' +
                '}';
    }
}
