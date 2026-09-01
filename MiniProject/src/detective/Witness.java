package detective;

public class Witness {

    private int id;
    private String name;
    private String statement;
    private String locationSeen;
    private String timeSeen;

    public Witness(int id, String name, String statement,
                   String locationSeen, String timeSeen) {

        this.id = id;
        this.name = name;
        this.statement = statement;
        this.locationSeen = locationSeen;
        this.timeSeen = timeSeen;
    }

    public void displayDetails() {

        System.out.println("\n----------- WITNESS -----------");
        System.out.println("Witness ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Statement    : " + statement);
        System.out.println("Location     : " + locationSeen);
        System.out.println("Time         : " + timeSeen);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatement() {
        return statement;
    }

    public String getLocationSeen() {
        return locationSeen;
    }

    public String getTimeSeen() {
        return timeSeen;
    }
}
