

package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String subjectName;
    @Column
    private int credit;
    @Column
    private String teacherName;

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

    public String getTeacherId() {
        return teacherName;
    }

    public void setTeacherId(String teacherName) {
        this.teacherName= teacherName;
    }

}
