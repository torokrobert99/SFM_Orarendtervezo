package hu.unideb.inf.model;

public class Teacher extends Person {

    private String subject;
    /* private String school; */
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

/*     public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    } */

}
