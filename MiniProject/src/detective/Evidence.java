package detective;

public class Evidence {

    private int evidenceId;
    private String name;
    private String type;
    private String description;
    private String foundAt;
    private boolean reliable;

    public Evidence(int evidenceId, String name, String type,
                    String description, String foundAt,
                    boolean reliable) {

        this.evidenceId = evidenceId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.foundAt = foundAt;
        this.reliable = reliable;
    }

    public void displayDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Evidence ID : " + evidenceId);
        System.out.println("Name        : " + name);
        System.out.println("Type        : " + type);
        System.out.println("Description : " + description);
        System.out.println("Found At    : " + foundAt);
        System.out.println("Reliability : " + (reliable ? "Reliable" : "Questionable"));
    }

    public int getEvidenceId() {
        return evidenceId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getFoundAt() {
        return foundAt;
    }

    public boolean isReliable() {
        return reliable;
    }
}