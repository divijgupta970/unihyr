package divij.com.unihyr.UtilClasses;


import org.json.JSONObject;

public class Products {
    private String id,position,location,initiator,hiringSpoc;
    private int totalProfiles;
    private boolean activated;
    private JSONObject jsonObject;

    public Products(String id, String position, String location, String initiator, String hiringSpoc, int totalProfiles, boolean activated,JSONObject jsonObject) {
        this.id = id;
        this.position = position;
        this.location = location;
        this.initiator = initiator;
        this.hiringSpoc=hiringSpoc;
        this.totalProfiles = totalProfiles;
        this.activated = activated;
        this.jsonObject=jsonObject;
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

    public JSONObject getJsonObject() {
        return jsonObject;
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
