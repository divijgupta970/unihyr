package divij.com.unihyr.UtilClasses;


public class Products {
    private String id,position,location,initiator,hiringSpoc;
    private int totalProfiles;
    private boolean activated;

    public Products(String id, String position, String location, String initiator, String hiringSpoc, int totalProfiles, boolean activated) {
        this.id = id;
        this.position = position;
        this.location = location;
        this.initiator = initiator;
        this.hiringSpoc=hiringSpoc;
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


    public int getTotalProfiles() {
        return totalProfiles;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getHiringSpoc() {
        return hiringSpoc;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
