package detective;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Case {

    private int caseId;
    private String caseTitle;
    private String crimeType;
    private String crimeLocation;
    private String crimeTime;

    private Victim victim;

    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witnesses;
    private ArrayList<Evidence> evidenceList;
    private ArrayList<TimelineEvent> timeline;
    private ArrayList<Location> locations;

    private HashMap<Integer, Suspect> suspectMap;

    public Case(int caseId, String caseTitle, String crimeType,
                String crimeLocation, String crimeTime) {

        this.caseId = caseId;
        this.caseTitle = caseTitle;
        this.crimeType = crimeType;
        this.crimeLocation = crimeLocation;
        this.crimeTime = crimeTime;

        suspects = new ArrayList<>();
        witnesses = new ArrayList<>();
        evidenceList = new ArrayList<>();
        timeline = new ArrayList<>();
        locations = new ArrayList<>();

        suspectMap = new HashMap<>();
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
    }

    public void addSuspect(Suspect suspect) {
        suspects.add(suspect);
        suspectMap.put(suspect.getId(), suspect);
    }

    public void addWitness(Witness witness) {
        witnesses.add(witness);
    }

    public void addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
    }

    public void addTimelineEvent(TimelineEvent event) {
        timeline.add(event);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Suspect findSuspectById(int id) {
        return suspectMap.get(id);
    }

    public Evidence findEvidenceById(int id) {
        for (Evidence evidence : evidenceList) {
            if (evidence.getEvidenceId() == id) {
                return evidence;
            }
        }
        return null;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public List<Witness> getWitnesses() {
        return witnesses;
    }

    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public List<TimelineEvent> getTimeline() {
        return timeline;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void displayCaseDetails() {

        System.out.println("\n========================================");
        System.out.println("              CASE DETAILS");
        System.out.println("========================================");
        System.out.println("Case ID       : " + caseId);
        System.out.println("Case Title    : " + caseTitle);
        System.out.println("Crime         : " + crimeType);
        System.out.println("Location      : " + crimeLocation);
        System.out.println("Time          : " + crimeTime);

        if (victim != null) {
            victim.displayDetails();
        }

        System.out.println("\n----------- SUSPECTS -----------");
        if (suspects.isEmpty()) {
            System.out.println("No suspects added.");
        } else {
            for (Suspect suspect : suspects) {
                suspect.displayDetails();
            }
        }

        System.out.println("\n----------- WITNESSES -----------");
        if (witnesses.isEmpty()) {
            System.out.println("No witnesses added.");
        } else {
            for (Witness witness : witnesses) {
                witness.displayDetails();
            }
        }

        System.out.println("\n----------- EVIDENCE -----------");
        if (evidenceList.isEmpty()) {
            System.out.println("No evidence collected.");
        } else {
            for (Evidence evidence : evidenceList) {
                evidence.displayDetails();
            }
        }

        System.out.println("========================================");
    }

    public void displayTimeline() {

        System.out.println("\n========================================");
        System.out.println("             CASE TIMELINE");
        System.out.println("========================================");

        if (timeline.isEmpty()) {
            System.out.println("No timeline events available.");
            return;
        }

        for (TimelineEvent event : timeline) {
            event.displayEvent();
        }

        System.out.println("========================================");
    }

    public void displayEvidenceList() {

        System.out.println("\n----------- AVAILABLE EVIDENCE -----------");

        if (evidenceList.isEmpty()) {
            System.out.println("No evidence collected.");
            return;
        }

        for (Evidence evidence : evidenceList) {
            System.out.println(
                    evidence.getEvidenceId() + ". " +
                    evidence.getName()
            );
        }
    }
}
