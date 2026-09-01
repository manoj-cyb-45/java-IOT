package detective;

public class Main {

    public static void main(String[] args) {

        Case detectiveCase = new Case(
                101,
                "The Blackwood Mystery",
                "Murder",
                "Blackwood Manor",
                "10:30 PM"
        );

        Victim victim = new Victim(
                "Jonathan Reed",
                45,
                "Businessman"
        );

        Suspect suspect1 = new Suspect(
                1,
                "Daniel Carter",
                38,
                "Business Partner",
                "Business Partner",
                "Claims he was at home",
                65
        );

        Suspect suspect2 = new Suspect(
                2,
                "Sarah Miller",
                32,
                "Journalist",
                "Friend",
                "Claims she was at a restaurant",
                40
        );

        Witness witness1 = new Witness(
                1,
                "Thomas Brown",
                "I saw someone leaving the library.",
                "Blackwood Manor Library",
                "10:20 PM"
        );

        detectiveCase.setVictim(victim);
        detectiveCase.addSuspect(suspect1);
        detectiveCase.addSuspect(suspect2);
        detectiveCase.addWitness(witness1);
        Evidence evidence1 = new Evidence(
                1,
                "Broken Watch",
                "Physical",
                "A broken wristwatch found near the crime scene.",
                "Library",
                true
        );

        Evidence evidence2 = new Evidence(
                2,
                "Torn Photograph",
                "Document",
                "A photograph with a person's face partially torn away.",
                "Victim's Office",
                false
        );

        Evidence evidence3 = new Evidence(
                3,
                "Footprint",
                "Physical",
                "A muddy footprint found near the library entrance.",
                "Library Entrance",
                true
        );

        Evidence evidence4 = new Evidence(
                4,
                "Anonymous Note",
                "Document",
                "A handwritten note containing a possible threat.",
                "Victim's Office",
                false
        );

        detectiveCase.addEvidence(evidence1);
        detectiveCase.addEvidence(evidence2);
        detectiveCase.addEvidence(evidence3);
        detectiveCase.addEvidence(evidence4);
        TimelineEvent event1 = new TimelineEvent(
                1,
                "9:00 PM",
                "Jonathan Reed enters the library.",
                "Library"
        );

        TimelineEvent event2 = new TimelineEvent(
                2,
                "9:30 PM",
                "Daniel Carter arrives at Blackwood Manor.",
                "Main Entrance"
        );

        TimelineEvent event3 = new TimelineEvent(
                3,
                "10:00 PM",
                "Thomas Brown hears an argument.",
                "Library"
        );

        TimelineEvent event4 = new TimelineEvent(
                4,
                "10:20 PM",
                "A person is seen leaving the library.",
                "Library"
        );

        TimelineEvent event5 = new TimelineEvent(
                5,
                "10:30 PM",
                "Jonathan Reed is found unconscious.",
                "Library"
        );

        detectiveCase.addTimelineEvent(event1);
        detectiveCase.addTimelineEvent(event2);
        detectiveCase.addTimelineEvent(event3);
        detectiveCase.addTimelineEvent(event4);
        detectiveCase.addTimelineEvent(event5);


        Investigation investigation =
                new Investigation(detectiveCase);

        investigation.start();
        Graph graph = new Graph();

        graph.addConnection("Daniel Carter", "Library");
        graph.addConnection("Library", "Broken Watch");
        graph.addConnection("Library", "Thomas Brown");
        graph.addConnection("Sarah Miller", "Victim's Office");
        graph.addConnection("Victim's Office", "Torn Photograph");

        graph.displayGraph();
    }
}