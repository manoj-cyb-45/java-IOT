package detective;

public class Main {

    public static void main(String[] args) {

        Case detectiveCase = createSampleCase();

        Investigation investigation =
                new Investigation(detectiveCase);

        investigation.start();
    }

    private static Case createSampleCase() {

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

        Suspect daniel = new Suspect(
                1,
                "Daniel Carter",
                38,
                "Business Partner",
                "Business Partner",
                "Claims he was at home",
                65
        );

        Suspect sarah = new Suspect(
                2,
                "Sarah Miller",
                32,
                "Journalist",
                "Close Friend",
                "Claims she was at a restaurant",
                40
        );

        Suspect michael = new Suspect(
                3,
                "Michael Brooks",
                51,
                "Estate Manager",
                "Employee",
                "Claims he was checking the west wing",
                55
        );

        Witness thomas = new Witness(
                1,
                "Thomas Brown",
                "I saw someone leaving the library.",
                "Library",
                "10:20 PM"
        );

        Witness emily = new Witness(
                2,
                "Emily Davis",
                "I heard a loud argument near the office.",
                "Victim's Office",
                "10:05 PM"
        );

        Evidence watch = new Evidence(
                1,
                "Broken Watch",
                "Physical",
                "A broken wristwatch found near the crime scene.",
                "Library",
                true,
                1,
                "The watch stopped at approximately 10:17 PM."
        );

        Evidence photograph = new Evidence(
                2,
                "Torn Photograph",
                "Document",
                "A photograph with one person's face partially torn away.",
                "Victim's Office",
                false,
                2,
                "The photograph appears connected to the victim's personal life."
        );

        Evidence footprint = new Evidence(
                3,
                "Muddy Footprint",
                "Physical",
                "A muddy footprint found near the library entrance.",
                "Library Entrance",
                true,
                3,
                "The footprint suggests someone entered from the garden."
        );

        Evidence note = new Evidence(
                4,
                "Anonymous Note",
                "Document",
                "A handwritten note containing a possible threat.",
                "Victim's Office",
                false,
                2,
                "The handwriting appears familiar to someone close to the victim."
        );

        Evidence key = new Evidence(
                5,
                "Master Key",
                "Physical",
                "A master key found near the west wing.",
                "West Wing",
                true,
                3,
                "The key belongs to the estate management set."
        );

        detectiveCase.setVictim(victim);

        detectiveCase.addSuspect(daniel);
        detectiveCase.addSuspect(sarah);
        detectiveCase.addSuspect(michael);

        detectiveCase.addWitness(thomas);
        detectiveCase.addWitness(emily);

        detectiveCase.addEvidence(watch);
        detectiveCase.addEvidence(photograph);
        detectiveCase.addEvidence(footprint);
        detectiveCase.addEvidence(note);
        detectiveCase.addEvidence(key);

        TimelineEvent event1 = new TimelineEvent(
                1, "9:00 PM",
                "Jonathan Reed enters the library.", "Library"
        );

        TimelineEvent event2 = new TimelineEvent(
                2, "9:30 PM",
                "Daniel Carter arrives at Blackwood Manor.", "Main Entrance"
        );

        TimelineEvent event3 = new TimelineEvent(
                3, "10:05 PM",
                "Emily Davis hears an argument.", "Victim's Office"
        );

        TimelineEvent event4 = new TimelineEvent(
                4, "10:17 PM",
                "The broken watch stops.", "Library"
        );

        TimelineEvent event5 = new TimelineEvent(
                5, "10:20 PM",
                "Thomas Brown sees someone leaving the library.", "Library"
        );

        TimelineEvent event6 = new TimelineEvent(
                6, "10:30 PM",
                "Jonathan Reed is found unconscious.", "Library"
        );

        detectiveCase.addTimelineEvent(event1);
        detectiveCase.addTimelineEvent(event2);
        detectiveCase.addTimelineEvent(event3);
        detectiveCase.addTimelineEvent(event4);
        detectiveCase.addTimelineEvent(event5);
        detectiveCase.addTimelineEvent(event6);

        Location library = new Location(
                1,
                "Library",
                "A large room containing old books and a reading area."
        );

        Location office = new Location(
                2,
                "Victim's Office",
                "The private office of the victim."
        );

        Location westWing = new Location(
                3,
                "West Wing",
                "A restricted area used by the estate manager."
        );

        Location garden = new Location(
                4,
                "Garden",
                "A garden connected to the library entrance."
        );

        library.addEvidence(watch);
        library.addEvidence(footprint);
        office.addEvidence(photograph);
        office.addEvidence(note);
        westWing.addEvidence(key);

        detectiveCase.addLocation(library);
        detectiveCase.addLocation(office);
        detectiveCase.addLocation(westWing);
        detectiveCase.addLocation(garden);

        return detectiveCase;
    }
}
