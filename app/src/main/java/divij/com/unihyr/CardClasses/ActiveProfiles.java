package divij.com.unihyr.CardClasses;

public class ActiveProfiles {
    private String name,submittedBy,channel,phone,status,currentRole,currentOrg,exp,np;

    public ActiveProfiles(String name, String submittedBy, String channel, String phone, String status, String currentRole, String currentOrg, String exp, String np) {
        this.name = name;
        this.submittedBy = submittedBy;
        this.channel = channel;
        this.phone = phone;
        this.status = status;
        this.currentRole = currentRole;
        this.currentOrg = currentOrg;
        this.exp = exp;
        this.np = np;
    }
    public String getName() {
        return name;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public String getChannel() {
        return channel;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public String getCurrentOrg() {
        return currentOrg;
    }

    public String getExp() {
        return exp;
    }

    public String getNp() {
        return np;
    }
}
