package divij.com.unihyr.UtilClasses;

public class Products {
    private String id,position,location,initiator;
    int upcoming,ongoing,past,totalProfiles;
    boolean activated;

    public Products(String id, String position, String location, String initiator, int upcoming, int ongoing, int past, int totalProfiles, boolean activated) {
        this.id = id;
        this.position = position;
        this.location = location;
        this.initiator = initiator;
        this.upcoming = upcoming;
        this.ongoing = ongoing;
        this.past = past;
        this.totalProfiles = totalProfiles;
        this.activated = activated;
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return location;
    }

    public String getInitiator() {
        return initiator;
    }

    public int getUpcoming() {
        return upcoming;
    }

    public int getOngoing() {
        return ongoing;
    }

    public int getPast() {
        return past;
    }

    public int getTotalProfiles() {
        return totalProfiles;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
