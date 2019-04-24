package DB.Entites;

public class Crop {
    private int id;
    private String name;
    private int crop_group_id;

    public Crop() {
    }

    public Crop(String name, int crop_group_id) {
        this.id = 0;
        this.name = name;
        this.crop_group_id = crop_group_id;
    }

    public Crop(Crop c) {
        this.name = c.getName();
        this.id = c.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrop_group_id() {
        return crop_group_id;
    }

    public void setCrop_group_id(int crop_group_id) {
        this.crop_group_id = crop_group_id;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crop_group_id=" + crop_group_id +
                '}';
    }
}
