
package config;


public class session {
    private static session instance;    
    private String uid;
    private String fname;
    private String lname;
    private String email;
    private String contact;
    private String user;
    private String type;
    private String status;
    
    public session() {
        
    }
    public static synchronized session getInstance() {
        if (instance == null){
            instance = new session ();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
        
        }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
