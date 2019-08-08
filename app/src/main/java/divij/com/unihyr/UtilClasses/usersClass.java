package divij.com.unihyr.UtilClasses;

public class usersClass {
    private String name,email,role,business,contact_no,created_on;

    public usersClass(String name, String email, String role, String business, String contact_no, String created_on) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.business = business;
        this.contact_no = contact_no;
        this.created_on = created_on;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }
}
