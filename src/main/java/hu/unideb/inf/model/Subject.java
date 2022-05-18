

package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subjectName;
    private int credit;
    private String targyfelelos;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "subject_id")
    private List<SubjectGroups> groups = new ArrayList<>();


    public List<SubjectGroups> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return subjectName + " - " + targyfelelos;
    }

    public void setGroups(SubjectGroups group) {
        groups.add(group);
    }



    public String getTargyfelelos() {return targyfelelos;}

    public void setTargyfelelos(String targyfelelos) {this.targyfelelos = targyfelelos;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String name) {
        this.subjectName = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
