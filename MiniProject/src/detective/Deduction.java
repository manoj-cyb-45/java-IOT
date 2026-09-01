package detective;

public class Deduction {

    private int id;
    private String description;

    public Deduction(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void display() {
        System.out.println(id + ". " + description);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
