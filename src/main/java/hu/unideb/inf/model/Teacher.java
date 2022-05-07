package hu.unideb.inf.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends Person implements Serializable {
    private String username;
    private String password;
   // private List<Subject> taughtSubjectsByThisTeacher = new ArrayList<>();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
