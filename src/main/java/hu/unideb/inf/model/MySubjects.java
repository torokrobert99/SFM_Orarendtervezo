package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class MySubjects implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int student_id;
    private String subject;
    private String nap;
    private String ora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNap() {
        return nap;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
}
