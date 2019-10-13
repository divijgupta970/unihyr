package divij.com.unihyr.CardClasses;

public class driver_ka {
    private String drive, location, position, cont_person, candidate, date, shortlisted,reject,noshow;

    public driver_ka(String drive, String location, String position, String cont_person, String candidate, String date, String shortlisted, String reject, String noshow) {
        this.drive = drive;
        this.location = location;
        this.position = position;
        this.cont_person = cont_person;
        this.candidate = candidate;
        this.date = date;
        this.shortlisted = shortlisted;
        this.reject = reject;
        this.noshow = noshow;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCont_person() {
        return cont_person;
    }

    public void setCont_person(String cont_person) {
        this.cont_person = cont_person;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShortlisted() {
        return shortlisted;
    }

    public void setShortlisted(String shortlisted) {
        this.shortlisted = shortlisted;
    }

    public String getReject() {
        return reject;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }

    public String getNoshow() {
        return noshow;
    }

    public void setNoshow(String noshow) {
        this.noshow = noshow;
    }
}
