package hu.unideb.inf.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Student extends Person implements Serializable {
    private String username;
    private String password;
    private String salt;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
