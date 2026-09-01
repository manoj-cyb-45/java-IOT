package detective;

public class Suspect {

    private int id;
    private String name;
    private int age;
    private String occupation;
    private String relationship;
    private String alibi;
    private int suspicionLevel;

    public Suspect(int id, String name, int age,
                   String occupation, String relationship,
                   String alibi, int suspicionLevel) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.relationship = relationship;
        this.alibi = alibi;
        this.suspicionLevel = suspicionLevel;
    }

    public void displayDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Suspect ID     : " + id);
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Occupation     : " + occupation);
        System.out.println("Relationship   : " + relationship);
        System.out.println("Alibi          : " + alibi);
        System.out.println("Suspicion      : " + suspicionLevel + "/100");
    }

    public void increaseSuspicion(int amount) {
        suspicionLevel += amount;
        if (suspicionLevel > 100) {
            suspicionLevel = 100;
        }
    }

    public void decreaseSuspicion(int amount) {
        suspicionLevel -= amount;
        if (suspicionLevel < 0) {
            suspicionLevel = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getAlibi() {
        return alibi;
    }

    public int getSuspicionLevel() {
        return suspicionLevel;
    }
}
