package detective;

import java.util.ArrayList;

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
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
    }

    public void addSuspect(Suspect suspect) {
        suspects.add(suspect);
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

    public void investigateEvidence() {

        System.out.println("\n========================================");
        System.out.println("          EVIDENCE INVESTIGATION");
        System.out.println("========================================");

        if (evidenceList.isEmpty()) {
            System.out.println("No evidence has been collected.");
            return;
        }

        for (Evidence evidence : evidenceList) {
            evidence.displayDetails();
        }
    }
    public Suspect findSuspectById(int id) {

        for (Suspect suspect : suspects) {

            if (suspect.getId() == id) {
                return suspect;
            }
        }

        return null;
    }
    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }
}