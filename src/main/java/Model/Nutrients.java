package Model;
import java.util.ArrayList;
import java.util.List;

public class Nutrients {
    private List<Double> basicRemoval = new ArrayList<>();
    private List<String> name = new ArrayList<>();

    public Nutrients() {

    }

    public List<Double> getBasicRemoval() {
        return basicRemoval;
    }

    public void setBasicRemoval(List<Double> basicRemoval) {
        this.basicRemoval = basicRemoval;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
