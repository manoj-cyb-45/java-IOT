package detective;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Investigation {

    private Case detectiveCase;
    private Scanner scanner;

    public Investigation(Case detectiveCase) {
        this.detectiveCase = detectiveCase;
        scanner = new Scanner(System.in);
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
                    detectiveCase.investigateEvidence();
                    break;

                case 4:
                    questionSuspect();
                    break;

                case 5:
                    checkAlibi();
                    break;

                case 0:
                    running = false;
                    System.out.println("\nInvestigation ended.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    private void displayMenu() {

        System.out.println("\n========================================");
        System.out.println("       DETECTIVE CASE INVESTIGATION");
        System.out.println("========================================");

        System.out.println("1. View Case Details");
        System.out.println("2. View Timeline");
        System.out.println("3. Investigate Evidence");
        System.out.println("4. Question Suspect");
        System.out.println("5. Check Alibi");
        System.out.println("0. Exit");

        System.out.println("========================================");
    }
    private void questionSuspect() {

        System.out.println("\n========================================");
        System.out.println("           QUESTION SUSPECT");
        System.out.println("========================================");

        System.out.print("Enter suspect ID: ");
        int id = scanner.nextInt();

        Suspect suspect = detectiveCase.findSuspectById(id);

        if (suspect == null) {
            System.out.println("\nSuspect not found.");
            return;
        }

        System.out.println("\nSuspect selected:");
        suspect.displayDetails();

        System.out.println("\n----------- INTERROGATION -----------");

        System.out.println("Detective: Where were you at the time of the crime?");

        System.out.println("\nSuspect's response:");
        System.out.println("\"" + suspect.getAlibi() + "\"");

        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Accept statement");
        System.out.println("2. Mark statement as suspicious");
        System.out.println("0. Return");

        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        if (choice == 2) {

            suspect.increaseSuspicion(15);

            System.out.println("\nThe statement has been marked as suspicious.");
            System.out.println("Suspicion level increased to "
                    + suspect.getSuspicionLevel() + "/100");

        } else if (choice == 1) {

            suspect.decreaseSuspicion(5);

            System.out.println("\nStatement recorded.");
            System.out.println("Suspicion level decreased to "
                    + suspect.getSuspicionLevel() + "/100");
        }
    }
    private void checkAlibi() {

        System.out.println("\n========================================");
        System.out.println("             CHECK ALIBI");
        System.out.println("========================================");

        System.out.print("Enter suspect ID: ");
        int id = scanner.nextInt();

        Suspect suspect = detectiveCase.findSuspectById(id);

        if (suspect == null) {
            System.out.println("\nSuspect not found.");
            return;
        }

        System.out.println("\nSuspect: " + suspect.getName());

        System.out.println("Claimed Alibi:");
        System.out.println("\"" + suspect.getAlibi() + "\"");

        System.out.println("\nKnown information:");

        detectiveCase.displayTimeline();

        System.out.println("\n----------------------------------------");
        System.out.println("ALIBI ANALYSIS");
        System.out.println("----------------------------------------");

        /*
         * Temporary analysis logic.
         * Later this will be replaced with a proper
         * timeline and evidence analysis algorithm.
         */

        if (suspect.getId() == 1) {

            System.out.println("Timeline shows Daniel Carter");
            System.out.println("arrived at Blackwood Manor at 9:30 PM.");

            System.out.println("\nAlibi Status: SUSPICIOUS");

            suspect.increaseSuspicion(15);

        } else {

            System.out.println("No contradiction found yet.");

            System.out.println("\nAlibi Status: UNVERIFIED");
        }

        System.out.println("Current Suspicion: "
                + suspect.getSuspicionLevel() + "/100");
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

        ranking.addAll(detectiveCase.getSuspects());

        if (ranking.isEmpty()) {
            System.out.println("No suspects available.");
            return;
        }

        int position = 1;

        while (!ranking.isEmpty()) {

            Suspect suspect = ranking.poll();

            System.out.println(
                    position + ". "
                            + suspect.getName()
                            + " - Suspicion: "
                            + suspect.getSuspicionLevel()
                            + "/100"
            );

            position++;
        }
    }
}