package detective;

import java.util.ArrayList;

public class Location {

    private int id;
    private String name;
    private String description;


    private ArrayList<Evidence> evidenceList;

    public Location(int id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;

        evidenceList = new ArrayList<>();
    }

    public void addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
    }

    public void displayLocation() {

        System.out.println("\n========================================");
        System.out.println("LOCATION: " + name);
        System.out.println("========================================");

        System.out.println("Description: " + description);

        System.out.println("\nEvidence found:");

        if (evidenceList.isEmpty()) {
            System.out.println("No evidence found here.");
        } else {
            for (Evidence evidence : evidenceList) {
                System.out.println("- " + evidence.getName());
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Evidence> getEvidenceList() {
        return evidenceList;
    }
}