package detective;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Investigation {

    private Case detectiveCase;
    private Scanner scanner;
    private Graph graph;

    public Investigation(Case detectiveCase) {

        this.detectiveCase = detectiveCase;
        scanner = new Scanner(System.in);

        graph = new Graph();

        buildCaseConnections();
    }

    private void buildCaseConnections() {

        // Connect evidence with locations and suspects
        for (Evidence evidence :
                detectiveCase.getEvidenceList()) {

            String evidenceId =
                    "E" + evidence.getEvidenceId();

            String locationId =
                    "L" + evidence.getFoundAt();

            GraphNode evidenceNode =
                    new GraphNode(
                            evidenceId,
                            evidence.getName(),
                            "Evidence"
                    );

            GraphNode locationNode =
                    new GraphNode(
                            locationId,
                            evidence.getFoundAt(),
                            "Location"
                    );

            graph.addConnection(
                    evidenceNode,
                    locationNode
            );

            Suspect suspect =
                    detectiveCase.findSuspectById(
                            evidence.getRelatedSuspectId()
                    );

            if (suspect != null) {

                GraphNode suspectNode =
                        new GraphNode(
                                "S" + suspect.getId(),
                                suspect.getName(),
                                "Suspect"
                        );

                graph.addConnection(
                        suspectNode,
                        evidenceNode
                );
            }
        }

        // Connect witnesses with locations
        for (Witness witness :
                detectiveCase.getWitnesses()) {

            GraphNode witnessNode =
                    new GraphNode(
                            "W" + witness.getId(),
                            witness.getName(),
                            "Witness"
                    );

            GraphNode locationNode =
                    new GraphNode(
                            "L" + witness.getLocationSeen(),
                            witness.getLocationSeen(),
                            "Location"
                    );

            graph.addConnection(
                    witnessNode,
                    locationNode
            );
        }
    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    detectiveCase.displayCaseDetails();
                    break;

                case 2:
                    detectiveCase.displayTimeline();
                    break;

                case 3:
                    examineEvidence();
                    break;

                case 4:
                    questionSuspect();
                    break;

                case 5:
                    checkAlibi();
                    break;

                case 6:
                    showSuspectRankings();
                    break;

                case 7:
                    findConnections();
                    break;

                case 0:

                    running = false;

                    System.out.println(
                            "\nInvestigation ended."
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice."
                    );
            }
        }
    }

    private void displayMenu() {

        System.out.println("\n========================================");
        System.out.println("       DETECTIVE CASE INVESTIGATION");
        System.out.println("========================================");

        System.out.println("1. View Case Details");
        System.out.println("2. View Timeline");
        System.out.println("3. Examine Evidence");
        System.out.println("4. Question Suspect");
        System.out.println("5. Check Alibi");
        System.out.println("6. View Suspect Rankings");
        System.out.println("7. Find Connections");
        System.out.println("0. Exit");

        System.out.println("========================================");
    }

    private void questionSuspect() {

        System.out.println("\n========================================");
        System.out.println("           QUESTION SUSPECT");
        System.out.println("========================================");

        System.out.print("Enter suspect ID: ");

        int id = scanner.nextInt();

        Suspect suspect =
                detectiveCase.findSuspectById(id);

        if (suspect == null) {

            System.out.println(
                    "\nSuspect not found."
            );

            return;
        }

        System.out.println("\nSuspect selected:");

        suspect.displayDetails();

        System.out.println(
                "\n----------- INTERROGATION -----------"
        );

        System.out.println(
                "Detective: Where were you at the time of the crime?"
        );

        System.out.println("\nSuspect's response:");

        System.out.println(
                "\"" + suspect.getAlibi() + "\""
        );

        System.out.println(
                "\nWhat would you like to do?"
        );

        System.out.println("1. Accept statement");
        System.out.println("2. Mark statement as suspicious");
        System.out.println("0. Return");

        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        if (choice == 2) {

            suspect.increaseSuspicion(15);

            System.out.println(
                    "\nThe statement has been marked as suspicious."
            );

            System.out.println(
                    "Suspicion level increased to "
                            + suspect.getSuspicionLevel()
                            + "/100"
            );

        } else if (choice == 1) {

            suspect.decreaseSuspicion(5);

            System.out.println(
                    "\nStatement recorded."
            );

            System.out.println(
                    "Suspicion level decreased to "
                            + suspect.getSuspicionLevel()
                            + "/100"
            );
        }
    }

    private void checkAlibi() {

        System.out.println("\n========================================");
        System.out.println("             CHECK ALIBI");
        System.out.println("========================================");

        System.out.print("Enter suspect ID: ");

        int id = scanner.nextInt();

        Suspect suspect =
                detectiveCase.findSuspectById(id);

        if (suspect == null) {

            System.out.println(
                    "\nSuspect not found."
            );

            return;
        }

        System.out.println(
                "\nSuspect: "
                        + suspect.getName()
        );

        System.out.println("Claimed Alibi:");

        System.out.println(
                "\"" + suspect.getAlibi() + "\""
        );

        System.out.println(
                "\nKnown information:"
        );

        detectiveCase.displayTimeline();

        System.out.println(
                "\n----------------------------------------"
        );

        System.out.println(
                "ALIBI ANALYSIS"
        );

        System.out.println(
                "----------------------------------------"
        );

        if (suspect.getId() == 1) {

            System.out.println(
                    "Timeline shows Daniel Carter"
            );

            System.out.println(
                    "arrived at Blackwood Manor at 9:30 PM."
            );

            System.out.println(
                    "\nAlibi Status: SUSPICIOUS"
            );

            suspect.increaseSuspicion(15);

        } else {

            System.out.println(
                    "No contradiction found yet."
            );

            System.out.println(
                    "\nAlibi Status: UNVERIFIED"
            );
        }

        System.out.println(
                "Current Suspicion: "
                        + suspect.getSuspicionLevel()
                        + "/100"
        );
    }

    private void showSuspectRankings() {

        System.out.println("\n========================================");
        System.out.println("          SUSPECT RANKINGS");
        System.out.println("========================================");

        PriorityQueue<Suspect> ranking =
                new PriorityQueue<>(
                        (s1, s2) ->
                                Integer.compare(
                                        s2.getSuspicionLevel(),
                                        s1.getSuspicionLevel()
                                )
                );

        ranking.addAll(
                detectiveCase.getSuspects()
        );

        if (ranking.isEmpty()) {

            System.out.println(
                    "No suspects available."
            );

            return;
        }

        int position = 1;

        while (!ranking.isEmpty()) {

            Suspect suspect =
                    ranking.poll();

            System.out.println(
                    position
                            + ". "
                            + suspect.getName()
                            + " - Suspicion: "
                            + suspect.getSuspicionLevel()
                            + "/100"
            );

            position++;
        }
    }

    private void findConnections() {

        System.out.println("\n========================================");
        System.out.println("          FIND CONNECTIONS");
        System.out.println("========================================");

        System.out.println("Example IDs:");
        System.out.println("S1 = Suspect");
        System.out.println("E1 = Evidence");
        System.out.println("LLibrary = Location");
        System.out.println("W1 = Witness");

        scanner.nextLine();

        System.out.print(
                "\nEnter first node ID: "
        );

        String first =
                scanner.nextLine();

        System.out.print(
                "Enter second node ID: "
        );

        String second =
                scanner.nextLine();

        graph.findConnection(
                first,
                second
        );
    }

    private void examineEvidence() {

        System.out.println("\n========================================");
        System.out.println("           EXAMINE EVIDENCE");
        System.out.println("========================================");

        detectiveCase.investigateEvidence();

        System.out.print(
                "\nEnter evidence ID: "
        );

        int id = scanner.nextInt();

        Evidence evidence =
                detectiveCase.findEvidenceById(id);

        if (evidence == null) {

            System.out.println(
                    "\nEvidence not found."
            );

            return;
        }

        System.out.println(
                "\n----------------------------------------"
        );

        System.out.println(
                "EVIDENCE EXAMINATION"
        );

        System.out.println(
                "----------------------------------------"
        );

        System.out.println(
                "Evidence : "
                        + evidence.getName()
        );

        System.out.println(
                "Type     : "
                        + evidence.getType()
        );

        System.out.println(
                "Found At : "
                        + evidence.getFoundAt()
        );

        System.out.println(
                "\nDescription:"
        );

        System.out.println(
                evidence.getDescription()
        );

        System.out.println(
                "\nReliability:"
        );

        System.out.println(
                evidence.isReliable()
                        ? "Reliable"
                        : "Questionable"
        );

        System.out.println(
                "\n----------------------------------------"
        );

        System.out.println(
                "INVESTIGATION RESULT"
        );

        System.out.println(
                "----------------------------------------"
        );

        if (evidence.getEvidenceId() == 1) {

            System.out.println(
                    "The watch stopped at approximately 10:17 PM."
            );

            System.out.println(
                    "This places the evidence close to the "
                            + "estimated crime period."
            );

        } else if (evidence.getEvidenceId() == 2) {

            System.out.println(
                    "The photograph appears to be connected "
                            + "to the victim's personal life."
            );

            System.out.println(
                    "The damaged portion may hide an important clue."
            );

        } else if (evidence.getEvidenceId() == 3) {

            System.out.println(
                    "The footprint appears to have been made "
                            + "shortly before the crime."
            );

            System.out.println(
                    "It may help identify who entered the library."
            );

        } else if (evidence.getEvidenceId() == 4) {

            System.out.println(
                    "The handwriting suggests the note was "
                            + "written by someone familiar with the victim."
            );

        } else {

            System.out.println(
                    "No additional information was discovered."
            );
        }
    }
}