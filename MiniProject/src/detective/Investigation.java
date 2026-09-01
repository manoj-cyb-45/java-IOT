package detective;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Investigation {

    private Case detectiveCase;
    private Scanner scanner;
    private Graph graph;
    private Stack<Deduction> deductionStack;

    public Investigation(Case detectiveCase) {

        this.detectiveCase = detectiveCase;
        scanner = new Scanner(System.in);
        graph = new Graph();
        deductionStack = new Stack<>();

        buildCaseConnections();
    }

    private void buildCaseConnections() {

        for (Evidence evidence : detectiveCase.getEvidenceList()) {

            GraphNode evidenceNode = new GraphNode(
                    "E" + evidence.getEvidenceId(),
                    evidence.getName(),
                    "Evidence"
            );

            GraphNode locationNode = new GraphNode(
                    "L" + cleanId(evidence.getFoundAt()),
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

                GraphNode suspectNode = new GraphNode(
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

        for (Witness witness : detectiveCase.getWitnesses()) {

            GraphNode witnessNode = new GraphNode(
                    "W" + witness.getId(),
                    witness.getName(),
                    "Witness"
            );

            GraphNode locationNode = new GraphNode(
                    "L" + cleanId(witness.getLocationSeen()),
                    witness.getLocationSeen(),
                    "Location"
            );

            graph.addConnection(
                    witnessNode,
                    locationNode
            );
        }
    }

    private String cleanId(String value) {
        return value.replaceAll("[^A-Za-z0-9]", "");
    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nPlease enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    detectiveCase.displayCaseDetails();
                    break;

                case 2:
                    showSortedTimeline();
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

                case 8:
                    showGraph();
                    break;

                case 9:
                    makeDeduction();
                    break;

                case 10:
                    viewDeductions();
                    break;

                case 11:
                    undoDeduction();
                    break;

                case 12:
                    investigateLocation();
                    break;

                case 13:
                    showGraphDFS();
                    break;

                case 0:
                    running = false;
                    System.out.println("\nInvestigation closed.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }

        scanner.close();
    }

    private void displayMenu() {

        System.out.println("\n========================================");
        System.out.println("       DETECTIVE CASE ENGINE");
        System.out.println("========================================");
        System.out.println("1. View Case Details");
        System.out.println("2. View Chronological Timeline");
        System.out.println("3. Examine Evidence");
        System.out.println("4. Question Suspect");
        System.out.println("5. Check Alibi");
        System.out.println("6. View Suspect Rankings");
        System.out.println("7. Find Connection (BFS)");
        System.out.println("8. View Connection Graph");
        System.out.println("9. Make Deduction");
        System.out.println("10. View Deductions");
        System.out.println("11. Undo Last Deduction");
        System.out.println("12. Investigate Location");
        System.out.println("13. Explore Graph (DFS)");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    private void showSortedTimeline() {

        List<TimelineEvent> sorted =
                new ArrayList<>(
                        detectiveCase.getTimeline()
                );

        sorted.sort(
                Comparator.comparingInt(
                        TimelineEvent::getMinutes
                )
        );

        System.out.println("\n========================================");
        System.out.println("        CHRONOLOGICAL TIMELINE");
        System.out.println("========================================");

        for (TimelineEvent event : sorted) {
            event.displayEvent();
        }
    }

    private void examineEvidence() {

        detectiveCase.displayEvidenceList();

        System.out.print("\nEnter evidence ID: ");
        int id = scanner.nextInt();

        Evidence evidence =
                detectiveCase.findEvidenceById(id);

        if (evidence == null) {
            System.out.println("\nEvidence not found.");
            return;
        }

        evidence.examine();

        Suspect suspect =
                detectiveCase.findSuspectById(
                        evidence.getRelatedSuspectId()
                );

        if (suspect != null) {

            int change = evidence.isReliable() ? 10 : 5;

            suspect.increaseSuspicion(change);

            System.out.println(
                    "\nRelated suspect: " +
                    suspect.getName()
            );

            System.out.println(
                    "Suspicion increased to " +
                    suspect.getSuspicionLevel() +
                    "/100"
            );
        }
    }

    private void questionSuspect() {

        System.out.print("\nEnter suspect ID: ");
        int id = scanner.nextInt();

        Suspect suspect =
                detectiveCase.findSuspectById(id);

        if (suspect == null) {
            System.out.println("\nSuspect not found.");
            return;
        }

        suspect.displayDetails();

        System.out.println(
                "\nSuspect response: \"" +
                suspect.getAlibi() + "\""
        );

        System.out.println("\n1. Accept statement");
        System.out.println("2. Mark as suspicious");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            suspect.decreaseSuspicion(5);

            System.out.println(
                    "Suspicion reduced to " +
                    suspect.getSuspicionLevel() +
                    "/100"
            );

        } else if (choice == 2) {

            suspect.increaseSuspicion(15);

            System.out.println(
                    "Suspicion increased to " +
                    suspect.getSuspicionLevel() +
                    "/100"
            );
        }
    }

    private void checkAlibi() {

        System.out.print("\nEnter suspect ID: ");
        int id = scanner.nextInt();

        Suspect suspect =
                detectiveCase.findSuspectById(id);

        if (suspect == null) {
            System.out.println("\nSuspect not found.");
            return;
        }

        System.out.println("\nSuspect: " + suspect.getName());
        System.out.println("Claimed alibi: " + suspect.getAlibi());

        System.out.println("\nTimeline evidence:");

        showSortedTimeline();

        System.out.println("\nALIBI RESULT");

        if (suspect.getId() == 1) {

            System.out.println(
                    "Contradiction detected: Daniel Carter " +
                    "was reported at the manor during the investigation window."
            );

            suspect.increaseSuspicion(15);

            System.out.println(
                    "Status: SUSPICIOUS"
            );

        } else {

            System.out.println(
                    "No direct contradiction has been established."
            );

            System.out.println(
                    "Status: UNVERIFIED"
            );
        }

        System.out.println(
                "Current suspicion: " +
                suspect.getSuspicionLevel() +
                "/100"
        );
    }

    private void showSuspectRankings() {

        PriorityQueue<Suspect> ranking =
                new PriorityQueue<>(
                        (first, second) ->
                                Integer.compare(
                                        second.getSuspicionLevel(),
                                        first.getSuspicionLevel()
                                )
                );

        ranking.addAll(
                detectiveCase.getSuspects()
        );

        System.out.println("\n========================================");
        System.out.println("          SUSPECT RANKINGS");
        System.out.println("========================================");

        int position = 1;

        while (!ranking.isEmpty()) {

            Suspect suspect = ranking.poll();

            System.out.println(
                    position + ". " +
                    suspect.getName() +
                    " - " +
                    suspect.getSuspicionLevel() +
                    "/100"
            );

            position++;
        }
    }

    private void findConnections() {

        System.out.println("\n========================================");
        System.out.println("          FIND CONNECTIONS");
        System.out.println("========================================");

        System.out.println("S1, S2, S3 = Suspects");
        System.out.println("E1, E2, E3 = Evidence");
        System.out.println("W1, W2     = Witnesses");
        System.out.println("LLibrary   = Library");
        System.out.println("LOffice    = Victim's Office");

        scanner.nextLine();

        System.out.print("\nEnter first node ID: ");
        String first = scanner.nextLine();

        System.out.print("Enter second node ID: ");
        String second = scanner.nextLine();

        graph.findConnection(first, second);
    }

    private void showGraph() {
        graph.displayGraph();
    }

    private void showGraphDFS() {

        System.out.print(
                "\nEnter starting node ID (example S1): "
        );

        scanner.nextLine();
        String start = scanner.nextLine();

        graph.depthFirstSearch(start);
    }

    private void makeDeduction() {

        scanner.nextLine();

        System.out.print(
                "\nEnter your deduction: "
        );

        String text = scanner.nextLine();

        if (text.trim().isEmpty()) {
            System.out.println(
                    "Deduction cannot be empty."
            );
            return;
        }

        int id = deductionStack.size() + 1;

        deductionStack.push(
                new Deduction(id, text)
        );

        System.out.println(
                "\nDeduction saved."
        );
    }

    private void viewDeductions() {

        System.out.println("\n========================================");
        System.out.println("          INVESTIGATOR NOTES");
        System.out.println("========================================");

        if (deductionStack.isEmpty()) {
            System.out.println("No deductions recorded.");
            return;
        }

        for (Deduction deduction : deductionStack) {
            deduction.display();
        }
    }

    private void undoDeduction() {

        if (deductionStack.isEmpty()) {
            System.out.println(
                    "\nThere are no deductions to undo."
            );
            return;
        }

        Deduction removed =
                deductionStack.pop();

        System.out.println(
                "\nRemoved: " +
                removed.getDescription()
        );
    }

    private void investigateLocation() {

        System.out.println("\n========================================");
        System.out.println("          LOCATION INVESTIGATION");
        System.out.println("========================================");

        List<Location> locations =
                detectiveCase.getLocations();

        for (Location location : locations) {

            System.out.println(
                    location.getId() +
                    ". " +
                    location.getName()
            );
        }

        System.out.print("\nEnter location number: ");
        int id = scanner.nextInt();

        for (Location location : locations) {

            if (location.getId() == id) {
                location.displayLocation();
                return;
            }
        }

        System.out.println("\nLocation not found.");
    }
}
