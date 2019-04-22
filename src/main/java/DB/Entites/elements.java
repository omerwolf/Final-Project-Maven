package DB.Entites;

public class elements {
    private int element_id;
    private String symbol;
    private String description;

    public elements(){

    }

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
