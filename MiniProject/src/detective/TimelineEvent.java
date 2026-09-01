package detective;

public class TimelineEvent {

    private int eventId;
    private String time;
    private String description;
    private String location;

    public TimelineEvent(int eventId, String time,
                         String description, String location) {

        this.eventId = eventId;
        this.time = time;
        this.description = description;
        this.location = location;
    }

    public void displayEvent() {

        System.out.println(
                eventId + ". " + time +
                " | " + description +
                " | Location: " + location
        );
    }

    public int getEventId() {
        return eventId;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getMinutes() {

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(
                parts[1].substring(0, 2)
        );

        if (time.toUpperCase().contains("PM") && hour != 12) {
            hour += 12;
        }

        if (time.toUpperCase().contains("AM") && hour == 12) {
            hour = 0;
        }

        return hour * 60 + minute;
    }
}
