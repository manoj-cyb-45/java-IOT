package detective;

public class Victim {

    private String name;
    private int age;
    private String occupation;

    public Victim(String name, int age, String occupation) {

        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void displayDetails() {

        System.out.println("\n----------- VICTIM -----------");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Occupation : " + occupation);
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
}