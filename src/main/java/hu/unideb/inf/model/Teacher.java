package hu.unideb.inf.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Teacher extends Person implements Serializable {
    private String username;
    private String password;

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
