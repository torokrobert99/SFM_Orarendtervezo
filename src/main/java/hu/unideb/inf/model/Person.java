package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private int age;
    //List<Student> listOfStudents = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Person.RoleType role;

    public enum RoleType{
        STUDENT,TEACHER
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
