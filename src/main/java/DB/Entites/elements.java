package DB.Entites;

/**
 * represents a record in the elements table
 * in the database.
 */
public class elements {
    private int element_id;
    private String symbol;
    private String description;

    /**
     * default constructor.
     */
    public elements(){

    }

    /**
     * creates an elements record with all necessary fields.
     * @param element_id - the element id.
     * @param symbol - the symbol of an element.
     * @param description - the element's name.
     */
    public elements(int element_id, String symbol, String description) {
        this.element_id = element_id;
        this.symbol = symbol;
        this.description = description;
    }

    /**
     * creates an elements record with all fields except the id.
     * the element id should be set after creating it.
     * @param symbol - the symbol of an element.
     * @param description - the element's name.
     */
    public elements(String symbol, String description) {
        this.element_id = 1;
        this.symbol = symbol;
        this.description = description;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
